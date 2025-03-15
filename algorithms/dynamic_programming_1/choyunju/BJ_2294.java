import java.io.*;
import java.util.*;

class BJ_2294 {
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        coins = new int[N+1];
        dp = new int[K+1];

        for(int i=1; i<=N; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }
        for(int i=1; i<=K; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }
        for(int i=1; i<=N; i++) {
            for(int j=coins[i]; j<=K; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        if(dp[K] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }

    }

}