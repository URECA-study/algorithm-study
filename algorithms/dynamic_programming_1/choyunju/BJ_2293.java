import java.io.*;
import java.util.*;

class BJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] coins = new int[N+1];
        int[] dp = new int[K+1];

        for(int i=1; i<=N; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 1;
        for(int i=1; i<=N; i++) {
            for(int j=coins[i]; j<=K; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        System.out.println(dp[K]);
    }
}