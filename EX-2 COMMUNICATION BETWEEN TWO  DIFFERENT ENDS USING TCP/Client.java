import java.net.*;
import java.io.*;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println("Host not found: " + u.getMessage());
        } catch (ConnectException ce) {
            System.out.println("Connection refused. Make sure the server is running.");
        } catch (IOException i) {
            System.out.println("Error establishing connection: " + i.getMessage());
        }

        if (socket != null && input != null && out != null) {
            String line = "";

            try {
                while (!line.equals("Over")) {
                    line = input.readLine();
                    out.writeUTF(line);
                }

                input.close();
                out.close();
                socket.close();
            } catch (IOException i) {
                System.out.println("Error during communication: " + i.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
