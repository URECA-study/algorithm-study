package dynamic_programming_1.GainLee;

import java.io.*;
import java.util.*;

public class Boj_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[][] map = new int[2][n];
            int[][] dp = new int[2][n];

            for (int j = 0; j < n; j++) {
                map[0][j] = Integer.parseInt(st.nextToken());
            } // for
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[1][j] = Integer.parseInt(st.nextToken());
            } // for

            dp[0][0] = Math.max(map[0][0], map[1][0]);
            dp[1][0] = Math.max(map[0][0], map[1][0]);

            if (n > 1) {
                dp[0][1] = map[0][1] + map[1][0];
                dp[1][1] = map[1][1] + map[0][0];
                for (int j = 2; j < n; j++) {
                    dp[0][j] = map[0][j] + Math.max(dp[1][j-2], dp[1][j-1]);
                    dp[1][j] = map[1][j] + Math.max(dp[0][j-2], dp[0][j-1]);
                } // dp table 갱신
            }
            int res = Math.max(dp[0][n-1], dp[1][n-1]);
            System.out.println(res);
        } // for
    } // main
}
