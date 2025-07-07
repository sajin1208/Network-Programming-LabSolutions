package lab32;

import java.net.Socket;

public class Q32Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            socket.setSoTimeout(5000); // 5 seconds
            socket.setTcpNoDelay(true);
            socket.setReuseAddress(true);
            socket.setReceiveBufferSize(2);
            socket.setSoLinger(true, 0);
            socket.setKeepAlive(false);

            System.out.println("Socket options set:");
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("TcpNoDelay: " + socket.getTcpNoDelay());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
            System.out.println("ReceiveBufferSize: " + socket.getReceiveBufferSize());
            System.out.println("Linger: " + socket.getSoLinger());
            System.out.println("So Keep Alive: " + socket.getKeepAlive());

        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
}
