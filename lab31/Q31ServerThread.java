package lab31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Q31ServerThread implements Runnable{
    private Socket socket;
    public Q31ServerThread (Socket socket) {
    this.socket = socket;
    }

    @Override
    public void run() {
    try {
      
        System.out.println("Client has connected.");
      
        // I/O buffers:
        BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
      
        String inputLine;
        while ((inputLine = in_socket.readLine()) != null) {
            try{
        int number = Integer.parseInt(inputLine);
        String result;
        if (isPrime(number)) {
            result = number + " is a prime number.";
        } else {
            result = number + " is not a prime number.";
        }
        System.out.println(result);
        out_socket.println(result); 
        }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    socket.close();
        System.out.println("Socket is closed.");
}
catch(Exception e)
{
    e.printStackTrace();
}}
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) return false;
    }
    return true;
    }
}
