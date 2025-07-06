package lab8;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class q8 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.1.84");
            NetworkInterface network = NetworkInterface.getByInetAddress(address);
            byte[] mac = network.getHardwareAddress();
            if (mac != null) {
                                // System.out.println("IP Address: "+ address);
            System.out.print("MAC Address of IP"+address+ " : ");
            for (int i = 0; i < mac.length; i++) {
                System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
            }
            System.out.println();
            } else {
            System.out.println("MAC Address not available.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        }

    }
    
}
