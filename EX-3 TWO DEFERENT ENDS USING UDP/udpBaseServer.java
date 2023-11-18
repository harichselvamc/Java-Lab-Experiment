import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class udpBaseServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1234);
            byte[] receive = new byte[65535];
            DatagramPacket DpReceive;

            System.out.println("Server started by HARICHSELVAM 211191101045");
            
            while (true) {
                DpReceive = new DatagramPacket(receive, receive.length);
                ds.receive(DpReceive);

                String receivedData = data(receive).toString();
                System.out.println("Client: " + receivedData);

                if (receivedData.equals("tata")) {
                    System.out.println("Client sent bye... EXITING");
                    break;
                }

                receive = new byte[65535];
            }

            ds.close();
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;

        StringBuilder ret = new StringBuilder();
        int i = 0;

        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }

        return ret;
    }
}
