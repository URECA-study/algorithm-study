package dynamic_programming_1.GainLee;

import java.io.*;

public class Boj_2579 {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void main (String[] args) throws IOException {
            int N = Integer.parseInt(br.readLine());
            int[] steps = new int[N+1];
            steps[0] = 0;
            int[] dp = new int [N+1];

            for (int i = 1; i <= N ; i++) {
                steps[i] = Integer.parseInt(br.readLine());
            } // for

            dp[0] = 0;
            dp[1] = steps[1];
            if (N == 1) {
                System.out.println(dp[1]);
                return;
            }
            dp[2] = steps[1] + steps[2];

            for (int i = 3; i <= N ; i++) {
                dp[i] = Math.max((dp[i-3] + steps[i-1]) + steps[i], dp[i-2] + steps[i]);
            } // for

            System.out.println(dp[N]);
            br.close();
        } // main
    }