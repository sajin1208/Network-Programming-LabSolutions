package lab21;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;

public class Q21 {
    public static void main(String[] args) {
         String url1 = "https://www.google.com";
        InputStream in = null;
        try {
            URI uri = new URI(url1);
            URL u = uri.toURL();
            in = u.openStream();
            in = new BufferedInputStream(in);
            Reader r = new InputStreamReader(in, "UTF-8");
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Error closing stream: " + e.getMessage());

                }
            }
        }
    } 
}
