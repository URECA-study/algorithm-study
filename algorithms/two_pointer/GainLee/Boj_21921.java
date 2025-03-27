package two_pointer.GainLee;

import java.io.*;
import java.util.*;

public class Boj_21921 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visiters = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        int cnt = 0;
        int tmp_sum = 0;
        int tmp_cnt = 0;

        for (int i = 0; i < n; i++) {
            visiters[i] = Integer.parseInt(st.nextToken());
            tmp_sum += visiters[i];
            tmp_cnt++;
            if (tmp_cnt == x) {
                if (tmp_sum > max) {
                    max = tmp_sum;
                    cnt = 1;
                } else if (tmp_sum == max) {
                    cnt++;
                }
                tmp_sum -= visiters[i-x+1];
                tmp_cnt--;
            }
        } // for

        if (max == 0) System.out.println("SAD");
        else System.out.print(max + "\n" + cnt);

        br.close();
    } // main

}
