package lab31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Q31ClientPrime {
    public Q31ClientPrime() throws Exception{
    Socket socket = new Socket("127.0.0.1",2020);
    System.out.println("Successful connection to the server.");
    
    // I/O streams
    BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
    PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

     String userInput;
        System.out.println("Enter a number:");
        while ((userInput = stdIn.readLine()) != null) {
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            out_socket.println(userInput); // Send to server
            String response = in_socket.readLine(); // Receive from server
            System.out.println("Server Response: " + response);
        }
    socket.close();
    System.out.println("Socket closed.");
  }

    public static void main(String[] args) {
        try {
            new Q31ClientPrime();

        } catch (Exception e) {
        e.printStackTrace();        
    }
    }
}
