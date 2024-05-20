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
            System.out.println("Jepni usernamin: ");
            String username = stdIn.readLine();
            System.out.println("Jepni passwordin: ");
            String password = stdIn.readLine();

            out.println(username);
            out.println(password);

            String response = in.readLine();
            System.out.println("Përgjigja e serverit: " + response);
            String token = response;

            while (true) {
                System.out.println("Jepni komandën 'kërko_të_dhëna' ose 'qkyquni': ");
                String command = stdIn.readLine();
                out.println(command);

                if (command.equals("qkyquni")) {
                    System.out.println("Duke u qkyqur...");
                    break;
                } else if (command.equals("kërko_të_dhëna")) {
                    out.println(token);
                    String serverResponse = in.readLine();
                    System.out.println("Përgjigja e serverit: " + serverResponse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
