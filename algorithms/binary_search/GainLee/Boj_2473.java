package binary_search.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        // 투 포인터
        long min_sum = Long.MAX_VALUE;
        int min_left = 0;
        int min_right = 0;
        int min_mid = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[left] + arr[i] + arr[right];
                if (Math.abs(sum) < min_sum) {
                    min_sum = Math.abs(sum);
                    min_left = i;
                    min_mid = left;
                    min_right = right;
                }
                if (sum >= 0) {
                    right--;
                } else {
                    left++;
                }
            } // while
        } // for

        System.out.println(arr[min_left] + " " + arr[min_mid] + " " + arr[min_right]);

    } // main
}