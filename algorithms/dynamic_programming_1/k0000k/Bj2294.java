package dynamic_programming_1.k0000k;

import java.io.*;
import java.util.*;

public class Bj2294 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] values;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        values = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value < k + 1) { // 유효한 입력이 들어올때만 처리하기
                values[i] = value;
                dp[value] = 1;
            }
        }

        for (int i = 0; i < k + 1; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 0; j < n; j++) {
                    int value = values[j];
                    if (i + value < k + 1) { // 같은 가치의 동전이 여러개 있어도 상관 없도록 구성
                        dp[i + value] = Math.min(dp[i + value], dp[i] + 1);
                    }
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[k]);
        }
    }
}
