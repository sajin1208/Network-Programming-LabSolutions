package lab4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class q4 {
    public static int getVersion(InetAddress ia){
        byte[] address = ia.getAddress();
        if(address.length == 4 ){
                return 4;
        } else if (address.length == 16) {
            return 6;
        }else {
            return -1;
        }
    }
    public static void main(String[] args) {
          try {

            String ip1 = "1050:0000:0000:0000:0005:0600:300c:326b";
            String ip2 = "192.168.1.01";
            int version1 = q4.getVersion(InetAddress.getByName(ip1));
            int version2 = q4.getVersion(InetAddress.getByName(ip2));
            System.out.println("Address: " + ip1 + " is IPv" + version1);
            System.out.println("Address: " + ip2 + " is IPv" + version2);
        } catch (UnknownHostException uhe) {
            System.out.println(uhe.getMessage());
        }
    }
}

