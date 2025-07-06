package lab10;

// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Q10 {
    public static void main(String[] args) {
        String urlsString ="https://www.google.com/";
        try {
            URI uri = new URI(urlsString);
            URL u = uri.toURL();
            try {
                Object o = u.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } 
            catch (IOException e) {
                System.err.println("ex");
            }
        } 
        catch (Exception e) {
            System.out.println(args[0] + " is not a parseale URL");
        }

        // try {
        //     URI uri = new URI("https://www.sweethome3d.com/");
        //     URL u = uri.toURL();
        //     BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
        //     String inputLine;
        //     while ((inputLine = in.readLine()) != null) {
        //     System.out.println(inputLine);
        // }
        // in.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    } 
}
