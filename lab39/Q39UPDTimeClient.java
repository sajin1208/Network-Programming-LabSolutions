package lab39;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Q39UPDTimeClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = new byte[1024];
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, serverAddress,1234);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);

            String serverTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server Time: " + serverTime);

        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
}
