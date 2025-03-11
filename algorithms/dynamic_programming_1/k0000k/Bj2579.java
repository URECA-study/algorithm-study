package dynamic_programming_1.k0000k;

import java.io.*;

public class Bj2579 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] steps;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        steps = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = steps[1];
        if (dp.length > 2) { // 입력되는 n이 자연수이므로, 1일수도 있음
            dp[2] = steps[1] + steps[2];
        }

        for (int i = 3; i < dp.length; i++) {
            // 1칸 점프하려면, 그 이전에는 반드시 2칸 점프 했어야 함.
            dp[i] = Math.max(dp[i], dp[i - 3] + steps[i - 1] + steps[i]);
            // 2칸 점프는 제한없음.
            dp[i] = Math.max(dp[i], dp[i - 2] + steps[i]);
        }

        System.out.println(dp[n]);

    }
}
