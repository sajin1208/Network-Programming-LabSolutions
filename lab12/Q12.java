package lab12;

import java.net.*;

public class Q12 {
    private static void testProtocol(String url)
    {
        try {
            URI u = new URI(url);
            URL ur = u.toURL();
            System.out.println(ur.getProtocol()+ " is supported");
        } catch (Exception e) {
            String protocol = url.substring(0,url.indexOf(':'));
        System.out.println(protocol + "is not supported");
        }
    }
    public static void main(String[] args) {
        //hypertext transfer protocol
        testProtocol("http://www.adc.org");
        //secure http
        testProtocol("https://www.google.com");
        //file transfer protocol
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");
        //SImple mail transfer protocol
        testProtocol("mailto:elharo@ibiblio.org");
        testProtocol("telnet://dibner.poly.edu/");
        //gopher
        testProtocol("gopher://gopher.anc.org.za/");
    }
    
}
