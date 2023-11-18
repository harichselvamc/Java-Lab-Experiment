import java.io.*;
import java.net.*;

class Filereceiver {
    public static void main(String args[]) throws IOException {
        Socket s = new Socket("127.0.0.1", 7777);

        if (s.isConnected()) {
            System.out.println("This program is done by HARICHSELVAM 211191101045");
            System.out.println("connected to server");
        }

        FileOutputStream fout = new FileOutputStream("Receive.txt");
        DataInputStream din = new DataInputStream(s.getInputStream());

        int r;
        while ((r = din.read()) != -1) {
            fout.write(r);
        }

        s.close();
        fout.close();
    }
}
