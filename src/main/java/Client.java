import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8080);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Enter username: ");
            String username = stdIn.readLine();
            System.out.println("Enter password: ");
            String password = stdIn.readLine();

            out.println(username);
            out.println(password);

            String response = in.readLine();
            System.out.println("Server response: " + response); // Debugging statement
            String token = response;

            while (true) {
                System.out.println("Enter command ('request_data' or 'logout'): ");
                String command = stdIn.readLine();
                out.println(command);

                if (command.equals("logout")) {
                    break;
                } else if (command.equals("request_data")) {
                    out.println(token);
                    String serverResponse = in.readLine();
                    System.out.println("Server response: " + serverResponse); // Debugging statement
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
