import java.io.*;
import java.util.*;

class BJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N+1][2];
        int dp[][] = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            token = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            arr[i][0] = w;  //i번째 물건의 무게
            arr[i][1] = v;  //i번째 물건의 가치
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-arr[i][0] >= 0) {  //현재 무게에서 i번째 물건의 무게를 빼도 남는 무게가 존재한다면
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}