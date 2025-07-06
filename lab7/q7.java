package lab7;

import java.net.InetAddress;
import java.net.NetworkInterface;
// import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter interface name : ");
        String interfaceName = scanner.nextLine().trim();
        scanner.close();

        try {
            NetworkInterface ni = NetworkInterface.getByName(interfaceName);

            if (ni == null) {
                System.out.println("No such interface found.");
                return;
            }

            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            if (!addresses.hasMoreElements()) {
                System.out.println("No IP addresses assigned to this interface.");
            }

            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                System.out.println("IP Address: " + address.getHostAddress());
            }

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // //From MAC
        // try {
        //     Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        //     while (interfaces.hasMoreElements()) {
        //         NetworkInterface ni = interfaces.nextElement();
        //         byte[] mac = ni.getHardwareAddress();

        //         if (mac != null) {
        //             StringBuilder macStr = new StringBuilder();
        //             for (byte b : mac) {
        //                 macStr.append(String.format("%02X-", b));
        //             }
        //             // Remove trailing dash
        //             macStr.setLength(macStr.length() - 1);

        //             if (macStr.toString().equals(inputMac)) {
        //                 Enumeration<InetAddress> addresses = ni.getInetAddresses();
        //                 while (addresses.hasMoreElements()) {
        //                     InetAddress addr = addresses.nextElement();
        //                     if (addr instanceof Inet4Address) {
        //                         System.out.println("IP Address: " + addr.getHostAddress());
        //                         return;
        //                     }
        //                 }
        //             }
        //         }
        //     }

        //     System.out.println("MAC address not found.");
        // }
        // catch(Exception e)
        // {}

    }
    
}