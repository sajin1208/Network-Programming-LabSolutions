package lab41;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Q41UPDArmstrongClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
        InetAddress address = InetAddress.getByName("localhost");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        String input = reader.readLine();

        byte[] sendBuffer = input.getBytes();
        byte[] receiveBuffer = new byte[1024];        
        DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, 12345);
        socket.send(packet);
        packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Server response: " + received);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
}
