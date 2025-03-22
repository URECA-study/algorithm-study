import java.io.*;
import java.util.*;

class BJ_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] num = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=1; j<=M; j++) {
                num[i][j] = Integer.parseInt(token.nextToken());
                //행을 기준으로 현재 열 = 이전 열들의 합 + 현재 열의 값
                dp[i][j] = dp[i][j-1] + num[i][j];
            }
        }

        int T = Integer.parseInt(reader.readLine());
        while(T-->0) {
            token = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            int result = 0;
            for(int i=x1; i<=x2; i++) {
                result = result + dp[i][y2] - dp[i][y1-1];
            }
            builder.append(result).append("\n");
        }
        System.out.println(builder);
    }
}