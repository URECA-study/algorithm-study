import java.io.*;
import java.util.*;

class BJ_1695 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int[] num = new int[N+1];

        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(token.nextToken());
        }

        int[][] dp = new int[N+1][N+1];

        //길이가 2일 때
        for(int i=1; i<=N-1; i++) {
            if(num[i] != num[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        //길이가 3이상일 때
        for(int length=3; length<=N; length++) {
            for(int i=length; i<=N; i++) {
                if(num[i-length+1] != num[i]) {
                    dp[i-length+1][i] = Math.min(dp[i-length+1][i-1], dp[i-length+2][i]) + 1;
                } else {
                    dp[i-length+1][i] = dp[i-length+2][i-1];
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}