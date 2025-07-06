package lab5;
import java.net.*;
import java.util.*;
public class q5 {
    public static void main(String[] args) throws SocketException{
     try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Interface Name: " + ni.getName());
        }
 } 
    catch (SocketException e) {
            e.printStackTrace();
    }   
}
}

