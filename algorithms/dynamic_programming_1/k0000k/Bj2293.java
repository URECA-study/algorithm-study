package dynamic_programming_1.k0000k;

import java.io.*;
import java.util.*;

public class Bj2293 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] values;
    public static int[] dp; // i를 만드는 경우의 수

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(values);
        dp = new int[k + 1];
        for (Integer v : values) {
            if (v > k) { // 문제를 읽어보면, k보다 작은값만 입력된다는 보장이 없다!
                continue;
            }
            dp[v] += 1;
            for (int i = 1; i < k + 1; i++) {
                if (i + v < k + 1) {
                    dp[i + v] += dp[i];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
