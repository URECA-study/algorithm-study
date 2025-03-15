import java.io.*;
import java.util.*;

class BJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer token = new StringTokenizer(reader.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            dp[i] = arr[i];
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);

    }
}