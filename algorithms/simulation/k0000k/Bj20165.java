package simulation.k0000k;

import java.io.*;
import java.util.*;

public class Bj20165 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] dominoes;
    public static boolean[][] isStand;
    public static HashMap<String, int[]> directions = new HashMap<>();
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        dominoes = new int[n][m];
        isStand = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                dominoes[i][j] = Integer.parseInt(st.nextToken());
                isStand[i][j] = true;
            }
        }

        directions.put("E", new int[]{0, 1});
        directions.put("W", new int[]{0, -1});
        directions.put("S", new int[]{1, 0});
        directions.put("N", new int[]{-1, 0});

        for (int i = 0; i < r; i++) {
            String[] input1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(input1[0]);
            int y1 = Integer.parseInt(input1[1]);
            attack(x1 - 1, y1 - 1, input1[2]); // 공격

            String[] input2 = br.readLine().split(" ");
            int x2 = Integer.parseInt(input2[0]);
            int y2 = Integer.parseInt(input2[1]);
            defense(x2 - 1, y2 - 1); // 방어
        }

        System.out.println(count);
        printArr();
    }

    private static void attack(int x, int y, String s) {
        int length = dominoes[x][y];
        int[] dir = directions.get(s);
        isStand[x][y] = false;
        count++;
        for (int i = 0; i < length - 1; i++) {
            x += dir[0];
            y += dir[1];
            if (isRange(x, y)) {
                if (!isStand[x][y]) {
                    continue;
                }
                attack(x, y, s); // 연쇄적으로 쓰러트리기
            }
        }
    }

    private static void defense(int x, int y) {
        isStand[x][y] = true;
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < dominoes.length) && (y >= 0) && (y < dominoes[0].length);
    }

    private static void printArr() {
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = 0; j < dominoes[0].length; j++) {
                if (isStand[i][j]) {
                    System.out.print("S ");
                }
                else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}
