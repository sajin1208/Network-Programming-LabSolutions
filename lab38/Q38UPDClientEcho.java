package lab38;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Q38UPDClientEcho {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 9876;

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName(serverHost);

            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();

            // Send packet to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            // Prepare buffer to receive echo
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Receive echo from server
            clientSocket.receive(receivePacket);

            String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Echo from server: " + echoedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
