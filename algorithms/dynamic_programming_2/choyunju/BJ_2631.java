import java.io.*;
import java.util.*;

class BJ_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp, 1);

        for(int i=1; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=1; i<=N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(N-max);
    }
}