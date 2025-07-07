package lab40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Q40UPDChatClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        while (true) {
            System.out.print("Client : ");
            String message = stdin.readLine();
            sendBuffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 2000);
            clientSocket.send(sendPacket);

            // response from server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server : " + reply);

            if (reply.equalsIgnoreCase("BYE")) {
                break;
            }
        }

        clientSocket.close();
    }
    
}
