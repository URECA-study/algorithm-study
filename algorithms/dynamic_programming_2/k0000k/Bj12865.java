package dynamic_programming_2.k0000k;

import java.io.*;
import java.util.*;

public class Bj12865 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] products;
    public static int[][] dp; // dp[i][j]는 j번째 물건까지 고려했을 때, 무게가 i인 가방을 최적으로 채우는 해

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        products = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp 초기화 (첫 번째 물건은 항상 넣을 수 있으니까 채워놓기)
        dp = new int[k + 1][n];
        for (int i = products[0][0]; i < dp.length; i++) {
            dp[i][0] = products[0][1];
        }

        for (int j = 1; j < dp[0].length; j++) {
            int weight = products[j][0];
            int value = products[j][1];
            for (int i = 0; i < dp.length; i++) {
                if (i >= weight) { // 가방의 크기가 현재 물건의 무게보다 크면, 넣을 수도 있고 넣지 않을 수도 있음.
                    dp[i][j] = Math.max(dp[i - weight][j - 1] + value, dp[i][j - 1]);
                }
                else { // 가방의 크기가 현재 물건의 크기보다 작으면 물건을 넣을 수 없음.
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);
    }

}
