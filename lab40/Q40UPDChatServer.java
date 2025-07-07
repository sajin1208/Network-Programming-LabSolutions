package lab40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Q40UPDChatServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(2000);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("UDP Chat Server is running.");

        while (true) {
            //packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Client : " + clientMessage);

            if (clientMessage.equalsIgnoreCase("END")) {
                String reply = "BYE";
                sendBuffer = reply.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
                break;
            }

            System.out.print("Server : ");
            String serverMessage = stdin.readLine();
            sendBuffer = serverMessage.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                    receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }

        serverSocket.close();
    }
    
}
