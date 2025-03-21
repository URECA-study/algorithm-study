package dynamic_programming_2.k0000k;

import java.io.*;
import java.util.*;

public class Bj2631 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] students;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (students[j] < students[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (maxVal < dp[i]) {
                maxVal = dp[i];
            }
        }

        System.out.println(n - maxVal);
    }
}
