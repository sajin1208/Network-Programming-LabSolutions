package lab3;

import java.net.InetAddress;

public class q3 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.10.68");
            System.out.println("Address:" + address.getHostAddress());
            System.out.println("Host name:" + address.getHostName());

            InetAddress address1 = InetAddress.getByName("192.168.1.1");
            System.out.println("isAnyLocalAddress(): " + address1.isAnyLocalAddress());

            InetAddress address2 = InetAddress.getByName("127.0.0.1");
            System.out.println("isLoopBackAddress(): " + address2.isLoopbackAddress());

            InetAddress address3 = InetAddress.getByName("169.254.1.23");
            System.out.println("isLinkLocalAddress():" + address3.isLinkLocalAddress());

            InetAddress address4 = InetAddress.getByName("10.255.255.255");
            System.out.println("isSiteLocalAddress():" + address4.isSiteLocalAddress());

            InetAddress address5 = InetAddress.getByName("224.0.0.0");
            System.out.println("isMulticastAddress():" + address5.isMulticastAddress());

            System.out.println("isMCGlobal():" + address.isMCGlobal());

            System.out.println("isMCNodeLocal():" + address.isMCNodeLocal());

            System.out.println("isMCLinkLocal():" + address.isMCLinkLocal());

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }
}
