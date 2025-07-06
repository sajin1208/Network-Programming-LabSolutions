package lab2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class q2 {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("LocalHost:" + InetAddress.getLocalHost());
            System.out.println("Address:" + address.getAddress());
            System.out.println("CanonicalHostName:" + address.getCanonicalHostName());
            System.out.println("Host Address: " + address.getHostAddress());
            System.out.println("Host Name: " + address.getHostName());
            
        }
        catch(UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
