package dynamic_programming_1.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2293 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n+1];
        int[] dp = new int[k+1];

        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <=k; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}