import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Serveri po pret në portin 8080");
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
                    System.out.println("Dërgo tokenin: " + token);
                } else {
                    out.println("Kredenciale të gabuara");
                    System.out.println("Janë dhënë kredenciale të gabuara.");
                }

                while (true) {
                    String request = in.readLine();
                    if (request != null) {
                        System.out.println("Kërkesa e marrë: " + request);
                        if (request.equals("qkyquni")) {
                            System.out.println("Klienti është qkyqur me sukses.");
                            break;
                        } else if (request.equals("kërko_të_dhëna")) {
                            String token = in.readLine();
                            System.out.println("Tokeni i marrë: " + token);
                            if (JwtUtil.validateToken(token, username)) {
                                out.println(" \"data\": \"Këto janë të dhëna të mbrojtura.\"");
                                System.out.println("Tokeni valid, dërgoni të dhëna të mbrojtura.");
                            } else {
                                out.println("Token invalid");
                                System.out.println("U pranua token invalid.");
                            }
                        } else {
                            System.out.println("U pranua komand invalide: " + request);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
