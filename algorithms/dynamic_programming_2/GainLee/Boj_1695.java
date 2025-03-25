package dynamic_programming_2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_1695 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        // 입력받기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // for

        int dp[][] = new int[n+1][n+1];

        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = (arr[i] == arr[i+1]) ? 0 : 1;
        }
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 만약 시작점과 끝점이 같다면 이전 거 갖고 오기
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+ 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[0][n-1]);
    }
}
