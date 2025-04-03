import java.io.*;
import java.util.*;

class BJ_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        while(T-->0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());
            int[][] arr = new int[N+1][N+1];

            for(int i=1; i<=N; i++) {
                token = new StringTokenizer(reader.readLine());
                for(int j=1; j<=N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            int[][] result = new int[N+1][N+1];

            //시계방향으로 회전
            if(d>0) {
                for(int k=0; k<d/45; k++) {
                    for(int i=1; i<=N; i++) {
                        for(int j=1; j<=N; j++) {
                            //주 대각선을 가운데 열로 옮긴다.
                            if(i==j) {
                                result[i][(N+1)/2] = arr[i][j];
                            }
                            //가운데 열을 부 대각선으로 옮긴다.
                            else if(j == (N+1)/2) {
                                result[i][N+1-i] = arr[i][j];
                            }
                            //부 대각선을 가운데 행으로 옮긴다.
                            else if(i+j == N+1) {
                                result[(N+1)/2][j] = arr[i][j];
                            }
                            //가운데 행을 주 대각선으로 옮긴다.
                            else if(i == (N+1)/2) {
                                result[j][j] = arr[i][j];
                            }
                            else {
                                result[i][j] = arr[i][j];
                            }
                        }
                    }
                    for(int i=1; i<=N; i++) {
                        for(int j=1; j<=N; j++) {
                            arr[i][j] = result[i][j];
                        }
                    }
                }
            }
            //반시계방향으로 회전
            else if(d<0){
                for(int k=0; k<Math.abs(d)/45; k++) {
                    for(int i=1; i<=N; i++) {
                        for(int j=1; j<=N; j++) {
                            //주 대각선을 가운데 행으로 옮긴다.
                            if(i==j) {
                                result[(N+1)/2][j] = arr[i][j];
                            }
                            //가운데 열을 주 대각선으로 옮긴다.
                            else if(j == (N+1)/2) {
                                result[i][i] = arr[i][j];
                            }
                            //부 대각선을 가운데 열로 옮긴다.
                            else if(i+j == N+1) {
                                result[i][(N+1)/2] = arr[i][j];
                            }
                            //가운데 행을 부 대각선으로 옮긴다.
                            else if(i == (N+1)/2) {
                                result[N+1-j][j] = arr[i][j];
                            }
                            else {
                                result[i][j] = arr[i][j];
                            }
                        }
                    }
                    for(int i=1; i<=N; i++) {
                        for(int j=1; j<=N; j++) {
                            arr[i][j] = result[i][j];
                        }
                    }
                }
            } else {
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        result[i][j] = arr[i][j];
                    }
                }
            }
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    builder.append(result[i][j] + " ");
                }
                builder.append("\n");
            }
        }
        System.out.println(builder);
    }
}