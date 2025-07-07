package lab30;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Q30ClientFile {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 45456);
            BufferedReader br = new BufferedReader(new FileReader("D:\\sajin.txt"));
            String str = br.readLine();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(str);
            System.out.println("Transfer Complete");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
