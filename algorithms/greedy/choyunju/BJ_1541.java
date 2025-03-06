import java.io.*;
import java.util.*;

class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] minus = s.split("-");

        for(int i=0; i<minus.length; i++) {
            if(minus[i].contains("+")) {
                String[] plus = minus[i].split("\\+");
                int n = 0;
                for(int j=0; j<plus.length; j++) {
                    n += Integer.parseInt(plus[j]);
                }
                minus[i] = Integer.toString(n);
            }
        }

        int result = Integer.parseInt(minus[0]);
        for(int i=1; i<minus.length; i++) {
            result -= Integer.parseInt(minus[i]);
        }
        System.out.println(result);
    }
}