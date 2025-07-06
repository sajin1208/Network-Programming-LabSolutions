package lab17;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class Q17 implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        try {
            String host = uri.getHost().toLowerCase();

            if (host.toLowerCase().endsWith(".gov")) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
public static void main(String[] args) throws Exception{
        Q17 policy = new Q17();

        CookieManager cm = new CookieManager();
        cm.setCookiePolicy(policy);
        CookieHandler.setDefault(cm);
        System.out.println("Blocking .gov domains.");

        URI govUri = new URI("https://www.usda.gov");
        URI comUri = new URI("http://example.com");
        HttpCookie cookie = new HttpCookie("test", "value");

        System.out.println("URL .gov? " + policy.shouldAccept(govUri, cookie));
        System.out.println("URL .com? " + policy.shouldAccept(comUri, cookie));
}
}
