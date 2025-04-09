import java.io.*;
import java.util.*;

class BJ_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int rotationLine = Math.min(N, M)/2;
        int[][] result = new int[N+1][M+1];

        for(int r=0; r<R; r++) {
            for(int line=1; line<=rotationLine; line++) {

                //왼쪽 방향으로 이동
                for(int k=line+1; k<=M-line+1; k++) {
                    result[line][k-1] = arr[line][k];
                }
                //아래쪽 방향으로 이동
                for(int k=line; k<=N-line; k++) {
                    result[k+1][line] = arr[k][line];
                }
                //오른쪽 방향으로 이동
                for(int k=line; k<=M-line; k++) {
                    result[N-line+1][k+1] = arr[N-line+1][k];
                }
                //위쪽 방향으로 이동
                for(int k=line+1; k<=N-line+1; k++) {
                    result[k-1][M-line+1] = arr[k][M-line+1];
                }
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    arr[i][j] = result[i][j];
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                builder.append(result[i][j] + " ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}