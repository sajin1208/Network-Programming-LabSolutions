package lab36;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Q36 {
    public static void main(String[] args) {
         try (DatagramSocket socket = new DatagramSocket()) {
        
            System.out.println("Socket information:");
            String message = "Hello javapoint!";
            byte[] buffer = message.getBytes();

            InetAddress address = InetAddress.getByName("javapoint.com");
            int port = 12345;

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            packet.setAddress(address);
            packet.setPort(port);
            packet.setData(buffer);
            packet.setLength(buffer.length);

            System.out.println("\nDatagramPacket information:");
            System.out.println("Destination: " + packet.getAddress());
            // System.out.println("Destination IP: " + packet.getAddress().getHostAddress());
            System.out.println("Destination Port: " + packet.getPort());
            System.out.println("Data Length: " + packet.getLength());
            System.out.println("Data: " + new String(packet.getData(), 0, packet.getLength()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
