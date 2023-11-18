import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void DownloadWebPage(String webpage, String fileName) {
        try {
            URL url = new URL(webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String line;

            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();

            System.out.println("THIS PROGRAM IS EXECUTED BY HARICHSELVAM 211191101045");
            System.out.println("Successfully Downloaded.");
        } catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        } catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

    public static void main(String args[]) throws IOException {
        String url = "https://www.drmgrdu.ac.in/contact.php";
        String fileName = "Data.html"; // You can change this to the desired file name
        DownloadWebPage(url, fileName);
    }
}
