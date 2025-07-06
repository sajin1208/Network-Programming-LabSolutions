package lab15;

import java.net.URLDecoder;

public class Q15 {
    public static void main(String[] args) {
        String input = "https://www.google.com/maps/@27.6699202,85.3251082,3164m/data=!3m1!1e3?entry=ttu&g_ep=EgoyMDI1MDUxMy4xIKXMDSoASAFQAw%3D%3D";
            try {
            String output = URLDecoder.decode(input, "UTF-8");
            System.out.println("Decoded URL is " + output);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
    }
    
}
