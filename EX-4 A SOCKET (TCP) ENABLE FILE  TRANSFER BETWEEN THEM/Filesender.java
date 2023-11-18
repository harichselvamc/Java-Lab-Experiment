import java.io.*;
import java.net.*;

class Filesender {
    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        Socket s = ss.accept();

        System.out.println("This program is done by HARICHSELVAM 211191101045");
        System.out.println("connected...");

        FileInputStream fin = new FileInputStream("send.txt");
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int r;
        while ((r = fin.read()) != -1) {
            dout.write(r);
        }

        System.out.println("\nFile transfer completed");

        s.close();
        ss.close();
    }
}
