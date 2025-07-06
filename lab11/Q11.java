package lab11;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Q11 {
    public static void main(String[] args) {
                    try {
                        URI uri = new URI("http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc");
                        URL u = uri.toURL();
                        System.out.println("The URL is " + u);
                        System.out.println("The host is " + u.getUserInfo());
                        System.out.println("The user info is " + u.getUserInfo());
                        System.out.println("The port is " + u.getPort());
                        System.out.println("The path is " + u.getPath());
                        System.out.println("The scheme is " + u.getProtocol());
                        System.out.println("The query string is " + u.getQuery());
                        System.out.println("The ref is " + u.getRef());
                    } catch (MalformedURLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    catch (URISyntaxException e) {
                        System.out.println(e.getMessage());
                    }

                } // end else

        } 
