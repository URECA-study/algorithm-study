package dynamic_programming_1.k0000k;

import java.io.*;
import java.util.*;

public class Bj11055 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] nums;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            nums[i] = val;
            dp[i] = val;
        }

        // i번째 숫자 전까지 있던 최댓값에 nums[i]를 더하기
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }

        // 최댓값 찾기
        int answer = 0;
        for (Integer num : dp) {
            if (num > answer) {
                answer = num;
            }
        }
        System.out.println(answer);
    }
}
