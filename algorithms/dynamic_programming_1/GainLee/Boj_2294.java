package dynamic_programming_1.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];

        for (int i = 0; i <= k; i++) {
            dp[i] = 100001;
        } // for

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            for (int j = 1; j <= k; j++) {
                if (j-temp >= 0) dp[j] = Math.min(dp[j], dp[j-temp] + 1);
            }
        }

        if (dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
