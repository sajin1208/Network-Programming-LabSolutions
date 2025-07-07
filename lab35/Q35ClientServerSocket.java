package lab35;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Q35ClientServerSocket {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8443;
        try {
            // Load TrustStore (server's certificate)
            KeyStore trustStore = KeyStore.getInstance("JKS");
            FileInputStream trustStoreFile = new FileInputStream("D:\\bca\\6th sem\\NetworkProgramming\\SSL\\mykeystore.jks");
            trustStore.load(trustStoreFile, "sajinman".toCharArray());

            // Initialize TrustManagerFactory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(trustStore);

            // Create SSL Context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Create SSL Socket
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket clientSocket = (SSLSocket) socketFactory.createSocket(host, port);
            System.out.println("Connected securely to server!");

            // Send message to server
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            output.println("Hello Secure Server!");
            System.out.println("Server Response: " + input.readLine());

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
