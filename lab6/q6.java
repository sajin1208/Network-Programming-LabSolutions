package lab6;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

public class q6 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("IP Address: " + address.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(address);
            byte[] mac = network.getHardwareAddress();
            if (mac != null) {
            try (Formatter formatter = new Formatter()) {
            for (int i = 0; i < mac.length; i++) {
            formatter.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
            }
            System.out.println("MAC Address: " + formatter.toString());
            }
            } else {
            System.out.println("MAC Address not available.");
            }
            } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

