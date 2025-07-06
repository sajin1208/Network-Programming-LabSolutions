package lab16;

import java.io.*;
import java.net.*;
import java.util.*;

public class Q16 extends ProxySelector {
    private List<URI> failed = new ArrayList<>();
    public List<Proxy> select(URI uri) {
    List<Proxy> result = new ArrayList<Proxy>();
    
    if (failed.contains(uri) || "http".equalsIgnoreCase(uri.getScheme())) {
    result.add(Proxy.NO_PROXY);
    } else {
    SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8000);
    Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
    result.add(proxy);
    }
    return result;
    }

    public void connectFailed(URI uri, SocketAddress address, IOException ex) {
    failed.add(uri);
    }

public static void main(String[] args)
{
    ProxySelector selector = new Q16();
    ProxySelector.setDefault(selector);
    System.out.println("Proxy Selector is set.");

}
}