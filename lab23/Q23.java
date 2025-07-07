package lab23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.net.URLConnection;

public class Q23 {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.paessler.com/login");
            URL url = uri.toURL();

            URLConnection connection = url.openConnection();

            connection.setDoInput(true);                          
            connection.setDoOutput(false);
            connection.setAllowUserInteraction(false);
            connection.setUseCaches(false);
            connection.setIfModifiedSince(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // 24 hrs 

            System.out.println("URLConnection Configuration");
            System.out.println("URL: " + connection.getURL());
            System.out.println("DoInput: " + connection.getDoInput());
            System.out.println("DoOutput: " + connection.getDoOutput());
            System.out.println("AllowUserInteraction: " + connection.getAllowUserInteraction());
            System.out.println("UseCaches: " + connection.getUseCaches());
            System.out.println("IfModifiedSince: " + connection.getIfModifiedSince());

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );
            String line;
            System.out.println("\nResponse Content");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
