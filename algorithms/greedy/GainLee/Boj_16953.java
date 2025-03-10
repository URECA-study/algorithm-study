package greedy.GainLee;

import java.io.*;
import java.util.*;

class Boj_16953 {
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int res = -1;
        int temp = b;

        while (true) {
            if (temp == a) {
                res = cnt;
                System.out.println(res);
                break;
            } else if (temp < a) {
                System.out.println(res);
                break;
            } else if (temp % 2 != 0 && temp % 10 != 1) {
                System.out.println(-1);
                break;
            }

            if (temp % 2 == 0) {
                temp = temp / 2;
                cnt++;
            } else if (temp % 2 != 0) {
                temp = (temp - 1) / 10;
                cnt++;
            }
        } // while

        br.close();
    }
}
