package dynamic_programming_2.k0000k;

import java.io.*;
import java.util.*;

public class Bj17485 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] space;
    public static int[][][] dp; // 이전에 어느 방향에서 왔는지를 함께 저장하기 위해 3차원 배열

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        space = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDp();

        // dp[i][j][k]는 k방향에서 온 dp[i][j]값들 중 최댓값을 의미
        int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int[] move : directions) {
                    int nextIdx = j + move[0];
                    if (!isRange(nextIdx)) {
                        continue;
                    }
                    dp[i + 1][nextIdx][move[0] + 1] = Math.min(dp[i + 1][nextIdx][move[0] + 1],
                            dp[i][j][move[1] + 1] + space[i + 1][nextIdx]);
                }
            }
        }

        int answer = findMin(dp[dp.length - 1]);
        System.out.println(answer);
    }

    public static void initDp() {
        dp = new int[space.length][space[0].length][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], 1000000);
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            Arrays.fill(dp[0][i], space[0][i]);
        }
    }

    private static boolean isRange(int num) {
        return (num >= 0) && (num < dp[0].length);
    }

    private static int findMin(int[][] arr) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < result) {
                    result = arr[i][j];
                }
            }
        }
        return result;
    }

}
