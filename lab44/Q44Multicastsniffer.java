package lab44;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class Q44Multicastsniffer {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SimpleMulticastSniffer <multicast-address> <port>");
            return;
        }

        try {
            InetAddress group = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());


            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(new InetSocketAddress(group, port), networkInterface);
	
            System.out.println("Sniffer started on group " + group.getHostAddress() + " port " + port);

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
