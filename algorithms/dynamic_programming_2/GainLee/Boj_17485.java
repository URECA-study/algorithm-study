package dynamic_programming_2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_17485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n+2][m+2][3];

        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                Arrays.fill(dp[i][j], 1000001);
            }
        }

        for (int j = 1; j <= m; j++) {
            dp[1][j][0] = map[1][j]; // 왼쪽 위에서 이동
            dp[1][j][1] = map[1][j]; // 위에서 이동
            dp[1][j][2] = map[1][j]; // 오른쪽 위에서 이동
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 >= 1) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];
                }
                dp[i][j][1] = Math.min(dp[i-1][j][2], dp[i-1][j][0]) + map[i][j];

                if (j + 1 <= m) {
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j];
                }
            }
        }

        // 출력
        int res = 1000001;
        for (int j = 1; j  <= m; j++) {
            res = Math.min(res, Math.min(dp[n][j][0], Math.min(dp[n][j][1], dp[n][j][2])));
        }
        System.out.println(res);

    } // main
}