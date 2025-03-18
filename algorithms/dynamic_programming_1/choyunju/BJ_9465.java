import java.io.*;
import java.util.*;

class BJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        while(T-->0) {
            int N = Integer.parseInt(reader.readLine());
            int[][] sticker = new int[2][N+1];
            for(int i=0; i<2; i++) {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                for(int j=1; j<=N; j++) {
                    sticker[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            int[][] dp = new int[2][N+1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            if(N>=2) {
                dp[0][2] = dp[1][1] + sticker[0][2];
                dp[1][2] = dp[0][1] + sticker[1][2];
            }

            for(int i=3; i<=N; i++) {
                dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + sticker[1][i];
            }
            int max = 0;
            for(int i=0; i<2; i++) {
                for(int j=1; j<=N; j++) {
                    if(max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
            builder.append(max).append("\n");
        }

        System.out.println(builder);
    }

}