package implementation.GainLee;
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Boj_16926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;
        for (int rotation = 0; rotation < r; rotation++) {
            for (int layer = 0; layer < layers; layer++) {
                int top = layer;
                int bottom = n - 1 - layer;
                int left = layer;
                int right = m - 1 - layer;

                int temp = map[top][left];

                // 윗변 왼쪽으로 이동
                for (int j = left; j < right; j++) {
                    map[top][j] = map[top][j + 1];
                }

                // 오른쪽 변 위로 이동
                for (int i = top; i < bottom; i++) {
                    map[i][right] = map[i + 1][right];
                }

                // 아랫변 오른쪽으로 이동
                for (int j = right; j > left; j--) {
                    map[bottom][j] = map[bottom][j - 1];
                }

                // 왼쪽 변 아래로 이동
                for (int i = bottom; i > top + 1; i--) {
                    map[i][left] = map[i - 1][left];
                }

                map[top + 1][left] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}