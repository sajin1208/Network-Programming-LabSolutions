package lab22;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Q22 {
    public static void main(String[] args) {
        try {
        URI uri = new URI("https://www.google.com");
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
        System.out.println(header.getKey() + ": " + header.getValue());
        }
        connection.disconnect();
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }
}
