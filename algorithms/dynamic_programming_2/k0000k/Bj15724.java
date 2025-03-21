package dynamic_programming_2.k0000k;

import java.io.*;
import java.util.*;

public class Bj15724 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] peoples;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        peoples = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                peoples[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeCumulativeArr(); // 누적합 배열로 만들기

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int r1 = peoples[x2][y2];
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;

            if (y1 > 0) {
                r2 = peoples[x2][y1 - 1];
            }
            if (x1 > 0) {
                r3 = peoples[x1 - 1][y2];
            }
            if (y1 > 0 && x1 > 0) {
                r4 = peoples[x1 - 1][y1 - 1];
            }

            int answer = r1 - r2 - r3 + r4;
            System.out.println(answer);
        }
    }

    // people[i][j]는 (0, 0) 부터 (i, j)까지의 인구 수의 합
    private static void makeCumulativeArr() {
        for (int i = 0; i < peoples.length; i++) {
            for (int j = 0; j < peoples[0].length - 1; j++) {
                peoples[i][j + 1] += peoples[i][j];
            }
        }

        for (int i = 0; i < peoples.length - 1; i++) {
            for (int j = 0; j < peoples[0].length; j++) {
                peoples[i + 1][j] += peoples[i][j];
            }
        }
    }
}
