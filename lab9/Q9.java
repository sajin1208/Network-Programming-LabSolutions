package lab9;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Q9 {
    public static void main(String[] args) {
        try {
            //getter method
            System.out.println("getter method");
            NetworkInterface eth0 = NetworkInterface.getByName("wireless_32769");
            Enumeration adddress =eth0.getInetAddresses();
            Enumeration<NetworkInterface> interfaces =NetworkInterface.getNetworkInterfaces();

            while (adddress.hasMoreElements()) 
            {
                System.out.println(adddress.nextElement());
                
            }

            while (interfaces.hasMoreElements()) 
            {
                System.out.println(interfaces.nextElement());
                
            }

            //Factory
            System.out.println("Factory method");
            InetAddress local = InetAddress.getByName("192.168.1.84");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);
            if(ni == null)
            System.out.println("No local loopback address");
            else{
                System.out.println("Local:" + local);
                 System.out.println("Interface Name: " + ni);

            }
            
        } catch (SocketException e) {
            System.out.println("could not found network interfaces");
        }
        catch(UnknownHostException ex)
        {
            System.err.println("could not lookup for ip");
        }
    }
    
}
