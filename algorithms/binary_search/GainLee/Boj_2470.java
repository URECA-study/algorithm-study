package binary_search.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2470 {
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
        int left = 0;
        int right = n-1;
        int min_left = 0;
        int min_right = 0;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if (Math.abs(sum) < min_sum) {
                min_sum = Math.abs(sum);
                min_left = left;
                min_right = right;
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(arr[min_left] + " " + arr[min_right]);

    } // main

}
