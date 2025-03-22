import java.io.*;
import java.util.*;

class BJ_17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N+1][M+1];
        // [][][0] = 오른쪽 아래 방향
        // [][][1] = 직선 아래 방향
        // [][][2] = 왼쪽 아래 방향
        int[][][] dp = new int[N+1][M+1][3];

        for(int i=1; i<=N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i=1; i<=M; i++) {
            for(int j=0; j<3; j++) {
                dp[1][i][j] = arr[1][i];
            }
        }

        for(int i=1; i<=M; i++) {
            if(i==1) {
                dp[2][i][1] = arr[1][i] + arr[2][i];
                dp[2][i][2] = arr[1][i+1] + arr[2][i];
            } else if(i==M) {
                dp[2][i][0] = arr[1][i-1] + arr[2][i];
                dp[2][i][1] = arr[1][i] + arr[2][i];
            } else {
                dp[2][i][0] = arr[1][i-1] + arr[2][i];
                dp[2][i][1] = arr[1][i] + arr[2][i];
                dp[2][i][2] = arr[1][i+1] + arr[2][i];
            }
        }

        for(int i=3; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                //첫 번째 Column인 경우 오른쪽 아래 방향(=0)이 존재X
                if(j == 1) {
                    dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
                //마지막 Column인 경우 왼쪽 아래 방향(=2)이 존재X
                else if(j == M) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=M; i++) {
            for(int j=0; j<3; j++) {
                if(dp[N][i][j] != 0 && dp[N][i][j] < min) {
                    min = dp[N][i][j];
                }
            }

        }
        System.out.println(min);
    }
}