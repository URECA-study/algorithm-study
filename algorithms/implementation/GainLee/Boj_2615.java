package implementation.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map = new int[20][20];
    static int[] dx = {-1, 1, 0, 1};
    static int[] dy = {1, 1, 1, 0};

    static Boolean checkWin (int x, int y, int dx, int dy, int color) {
        int cnt = 0;
        int nx = x;
        int ny = y;

        while (nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19 && map[nx][ny] == color) {
            nx += dx;
            ny += dy;
            cnt++;
        }

        if (cnt != 5) return false;

        int pre_x = x - dx;
        int pre_y = y - dy;

        if (pre_x >= 1 && pre_y >= 1 && pre_x <= 19 && pre_y <= 19 && map[pre_x][pre_y] == color) {
            return false;
        }

        return true;
    } // checkWin

    public static void main(String[] args) throws IOException {
        boolean found = false;
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // for

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] == 0) continue;

                int color = map[i][j];
                for (int k = 0; k < 4; k++) {
                    if (checkWin(i, j, dx[k], dy[k], color)) {
                        found = true;
                        System.out.println(color);
                        System.out.println(i + " " + j);
                        return;
                    }
                }

            }
        } // for

        if(!found) System.out.println(0);


    } // main
}
