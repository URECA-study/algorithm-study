package simulation.k0000k;

import java.io.*;
import java.util.*;

public class Bj21922 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] room;
    public static boolean[][] prefer;
    public static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefer = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 9) {
                    prefer[i][j] = true;
                    for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
                        int dx = directions[dirIdx][0];
                        int dy = directions[dirIdx][1];
                        airConditioner(i + dx, j + dy, dirIdx);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefer[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void airConditioner(int i, int j, int dirIdx) {
        while (isRange(i, j) && room[i][j] != 9) {
            prefer[i][j] = true;
            if (room[i][j] == 1 && dirIdx % 2 == 1) { // 가로 방향만 반대로 돌리기
                dirIdx = (dirIdx + 2) % 4;
            }
            else if (room[i][j] == 2 && dirIdx % 2 == 0) { // 세로 방향만 반대로 돌리기
                dirIdx = (dirIdx + 2) % 4;
            }
            else if (room[i][j] == 3) {
                if (dirIdx % 2 == 0) {
                    dirIdx += 1;
                } else {
                    dirIdx -= 1;
                }
            }
            else if (room[i][j] == 4) {
                dirIdx = (3 - dirIdx);
            }
            i += directions[dirIdx][0];
            j += directions[dirIdx][1];
        }
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < room.length) && (y >= 0) && (y < room[0].length);
    }
}
