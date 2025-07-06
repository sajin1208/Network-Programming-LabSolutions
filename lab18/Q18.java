package lab18;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class Q18 {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        URI uri = URI.create("https://www.example.org/");

        // creating cookies and URI
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");

        // Add(URI uri, HttpCookie cookie)
        cookieStore.add(uri, cookieA);
        cookieStore.add(null, cookieB);
        System.out.println("Cookies successfully added\n");
        
        // Method getCookies()
        List cookieList = cookieStore.getCookies();
        System.out.println("Cookies in CookieStore : "+ cookieList + "\n");

    }
    
}
