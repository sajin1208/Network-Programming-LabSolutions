package lab26;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Q26Client {
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public Q26Client(String addr, int port)
    {
        try {
            s = new Socket(addr, port);
            System.out.println("Connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            out = new DataOutputStream(s.getOutputStream());

            String m = "";

        while (!m.equals("Over")) {
            try {
                m = reader.readLine();
            out.writeUTF(m);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }}
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }
        System.out.println("Thank you");

        try {
            in.close();
            out.close();
            s.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Q26Client c = new Q26Client("127.0.0.1", 5000);
    }
    
}
