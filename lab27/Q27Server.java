package lab27;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Q27Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(45456);
        Socket s = ss.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Date dt = new Date();
        out.writeUTF(dt.toString());
        out.flush();
        
    }
    
}
