package lab38;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Q38UPDServerEcho {
    public static void main(String[] args) {
        int port = 9876;

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Echo Server is running on port ");

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                // Receive packet
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                // Extract data
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedData);

                // echo back
                byte[] sendData = receivedData.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                // Sending response back to client
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
    
}
