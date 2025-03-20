package dynamic_programming_2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 물건의 개수
        k = Integer.parseInt(st.nextToken()); // 최대 무게
        int[][] things = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건 무게
            int v = Integer.parseInt(st.nextToken()); // 물건 가치
            things[i][0] = w;
            things[i][1] = v;
        }

        int[] dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j-things[i][0] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-things[i][0]] + things[i][1]);
            } // for
        } // for
        System.out.println(dp[k]);
    }
}
