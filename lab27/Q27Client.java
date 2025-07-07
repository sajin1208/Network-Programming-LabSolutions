package lab27;

import java.io.DataInputStream;
import java.net.Socket;

public class Q27Client {
    public static void main(String[] args) throws Exception{
        Socket soc = new Socket("localhost",45456);
        DataInputStream in = new DataInputStream(soc.getInputStream());
        String date = in.readUTF();
        System.out.println("Date From Server: "+date);
    }
    
}
