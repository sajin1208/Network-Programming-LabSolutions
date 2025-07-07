package lab20;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Q20 {
    public static void main(String[] args) throws Exception{
        System.out.println("Arbitrary Header Fields");

        URI uri = new URI("https://google.com");
        URL u = uri.toURL();
        URLConnection uc = u.openConnection();

        String contentType = uc.getHeaderField("content-type");
        String contentEncoding = uc.getHeaderField("content-encoding");
        // String expires = uc.getHeaderField("expires");
        String contentLength = uc.getHeaderField("Content-length");
        String header6 = uc.getHeaderFieldKey(6);
        Date expiresDate = new Date(uc.getHeaderFieldDate("expires", 0));
        // long lastModified = uc.getHeaderFieldDate("last-modification", 0);
        // Date now = new Date(uc.getHeaderFieldDate("date", 0));
        int contentLengthint = uc.getHeaderFieldInt("content-length", -1);

        System.out.println("Content-Type(Header Field String): " + contentType);
        System.out.println("Content-Encoding: " + contentEncoding);
        System.out.println("HeaderField Date: " + expiresDate);
        System.out.println("Content-Length (String): " + contentLength);
        System.out.println("HeaderField Int: " + contentLengthint);
        System.out.println("HeaderField Key: " + header6);
        // System.out.println("Date: " + now);
    }
}
