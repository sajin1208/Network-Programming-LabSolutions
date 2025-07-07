package lab42;

import java.net.DatagramSocket;

public class Q42UPDSocketOptions {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
        socket.setSoTimeout(5000);
        socket.setReuseAddress(true);
        socket.setBroadcast(false);


        System.out.println("Socket options set:");
        System.out.println("SoTimeout: " + socket.getSoTimeout());
        System.out.println("ReuseAddress: " + socket.getReuseAddress());
        System.out.println("Broadcast: " + socket.getBroadcast());
        System.out.println("RecieveBuffer Size: " + socket.getReceiveBufferSize());

        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
}
