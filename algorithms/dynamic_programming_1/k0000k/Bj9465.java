package dynamic_programming_1.k0000k;

import java.io.*;
import java.util.*;

public class Bj9465 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] stickers;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stickers[0][j] = Integer.parseInt(st1.nextToken());
                stickers[1][j] = Integer.parseInt(st2.nextToken());
            }

            dp = new int[2][n];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < 2; y++) {
                    int afterY = (y + 1) % 2;
                    // 다음 스티커를 고르는 경우는 2가지
                    if (x + 1 < n) {
                        dp[afterY][x + 1] = Math.max(dp[afterY][x + 1], dp[y][x] + stickers[afterY][x + 1]);
                    }
                    if (x + 2 < n) {
                        dp[afterY][x + 2] = Math.max(dp[afterY][x + 2], dp[y][x] + stickers[afterY][x + 2]);
                    }
                }
            }

            int answer = findMax(dp);
            System.out.println(answer);
        }
    }

    private static int findMax(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > result) {
                    result = arr[i][j];
                }
            }
        }
        return result;
    }

}
