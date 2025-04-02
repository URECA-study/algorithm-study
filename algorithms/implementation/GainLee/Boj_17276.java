package implementation.GainLee;

import java.io.*;
import java.util.*;

public class Boj_17276 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] map = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // for - map 입력

            d = ((d % 360) + 360) % 360;

            for (int q = d; q > 0; q -= 45) {
                int[][] new_map = new int[n+1][n+1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        // 1. 주 대각선 이동
                        if (i == j) {
                            new_map[i][(n+1)/2] = map[i][j];
                        }
                        // 2. 가운데 열 이동
                        else if  (j == (n+1)/2) {
                            new_map[i][n-i+1] = map[i][j];
                        }
                        // 3. 부대각선 이동
                        else if ( i == n-j+1 ) {
                            new_map[(n+1)/2][j] = map[i][j];
                        }
                        // 4. 가운데 행 이동
                        else if (i == (n+1)/2){
                            new_map[j][j] = map[i][j];
                        }
                        else {
                            new_map[i][j] = map[i][j];
                        }
                    }
                } // for - map 이동
                map= new_map;
            }
            // 출력
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        } // for - t
        br.close();
    } // main
}
