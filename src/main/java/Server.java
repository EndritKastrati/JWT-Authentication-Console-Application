import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String username = in.readLine();
                String password = in.readLine();

                if ("endrit".equals(username) && "12345".equals(password)) {
                    String token = JwtUtil.generateToken(username);
                    out.println(token);
                    System.out.println("Sent Token: " + token); // Debugging statement
                } else {
                    out.println("Invalid credentials");
                    System.out.println("Invalid credentials provided."); // Debugging statement
                }

                while (true) {
                    String request = in.readLine();
                    if (request != null) {
                        System.out.println("Received Request: " + request); // Debugging statement
                        if (request.equals("logout")) {
                            System.out.println("Client logged out."); // Debugging statement
                            break;
                        } else if (request.equals("request_data")) {
                            String token = in.readLine();
                            System.out.println("Received Token: " + token); // Debugging statement
                            if (JwtUtil.validateToken(token, username)) {
                                out.println("{ \"data\": \"This is protected data.\" }");
                                System.out.println("Token valid, sent protected data."); // Debugging statement
                            } else {
                                out.println("Invalid token");
                                System.out.println("Invalid token received."); // Debugging statement
                            }
                        } else {
                            System.out.println("Unknown command received: " + request); // Debugging statement
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
