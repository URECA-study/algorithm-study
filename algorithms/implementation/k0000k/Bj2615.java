package implementation.k0000k;

import java.io.*;
import java.util.*;

public class Bj2615 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] board = new int[19][19];
    public static int[][] directions = new int[][] {{0, 1}, {1, 1}, {1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) { // 바둑알을 발견하면 탐색 시작
                    flag = startCount(i, j);
                }
                if (flag != 0) {
                    System.out.println(flag);
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static int startCount(int x, int y) {
        for (int[] dir : directions) {
            int pastX = x - dir[0];
            int pastY = y - dir[1];
            // 이전 방향에 같은 돌이 없어야 탐색 가능
            if (!isRange(pastX, pastY) || board[pastX][pastY] != board[x][y]) {
                int count = 1;
                int afterX = x + dir[0];
                int afterY = y + dir[1];
                // 한 방향으로 계속 가면서, 다른 바둑돌을 만나서나 경계를 넘어갈때까지 탐색
                while (isRange(afterX, afterY) && board[afterX][afterY] == board[x][y]) {
                    count++;
                    afterX += dir[0];
                    afterY += dir[1];
                }
                if (count == 5) { // 탐색하며 만난 바둑돌의 갯수가 정확히 5개이면 종료
                    return board[x][y];
                }
            }
        }
        return 0; // 5개 연속해서 위치한 케이스가 없으면 0 리턴
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < 19) && (y >= 0) && (y < 19);
    }
}
