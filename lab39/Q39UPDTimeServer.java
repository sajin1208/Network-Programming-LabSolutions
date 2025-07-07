package lab39;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class Q39UPDTimeServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1234)) {
            System.out.println("UDP Daytime Server started on port ");

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String time = new Date().toString();
                byte[] timeBytes = time.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        timeBytes,
                        timeBytes.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );
                socket.send(sendPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
}
