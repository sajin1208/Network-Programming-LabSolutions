package lab33;

import java.net.ServerSocket;
import java.net.Socket;

public class Q33Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
        serverSocket.setReuseAddress(true);
        System.out.println("Server socket options set:");
        System.out.println("ReuseAddress: " + serverSocket.getReuseAddress());

        while (true) {
        Socket clientSocket = serverSocket.accept();
        clientSocket.setSoTimeout(5000); // 5 seconds timeout
        clientSocket.setTcpNoDelay(true);
        clientSocket.setReceiveBufferSize(2);
        clientSocket.setKeepAlive(true);
        clientSocket.setSoLinger(true,0);
       
        System.out.println("Client socket options set:");
        System.out.println("SoTimeout: " + clientSocket.getSoTimeout());
        System.out.println("TcpNoDelay: " + clientSocket.getTcpNoDelay());
        System.out.println("BufferSize: " + clientSocket.getReceiveBufferSize());
        System.out.println("Linger: " + clientSocket.getSoLinger());
        System.out.println("keep alive: " + clientSocket.getKeepAlive());

        }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
}
