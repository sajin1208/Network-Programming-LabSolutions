package lab45;

import java.rmi.Naming;
import java.util.Scanner;

public class GCDClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();
            GCDInterface gcd = (GCDInterface) Naming.lookup("rmi://localhost/GCDServer");
            System.out.println("GCD of " + a + " and " + b + " is: " + gcd.gcd(a, b));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
