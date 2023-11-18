import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpBaseClient {
    public static void main(String args[]) {
        try {
            System.out.println("Client started by HARICHSELVAM 211191101045");
            Scanner sc = new Scanner(System.in);
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getLocalHost();
            byte[] buf;

            while (true) {
                String input = sc.nextLine();
                buf = input.getBytes();
                DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
                ds.send(DpSend);

                if (input.equals("tata")) {
                    break;
                }
            }

            ds.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
