package lab31;

import java.net.ServerSocket;
import java.net.Socket;

//multithread TCP
public class Q31ServerPrime {
public Q31ServerPrime() throws Exception{
    try {
            ServerSocket server_socket = new ServerSocket(2020);
    System.out.println("Port 2020 is now open.");
    
    // infinite while loop: wait for new connections
    while(true) {
      Socket socket = server_socket.accept();
      Q31ServerThread server_thread = new Q31ServerThread(socket);
      Thread thread = new Thread(server_thread);
      thread.start();
        } }catch (Exception e) {
            e.printStackTrace();
        }
}
    public static void main(String[] args) {
        try {
            new Q31ServerPrime();
        } catch (Exception e) {
            e.printStackTrace();        
        }

    }
    
  }

