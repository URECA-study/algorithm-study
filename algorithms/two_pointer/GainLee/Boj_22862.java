package two_pointer.GainLee;

import java.io.*;
import java.util.*;

public class Boj_22862 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] check_even = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 홀수면 0, 짝수면 1
            if (0 != arr[i] % 2) {
                check_even[i] = 0;
            } else {
                check_even[i] = 1;
            }
        } // for


        int start = 0;
        int end = 0;
        int cnt = 0;
        int len = 0;

        while (end < n) {
            // 현재 숫자가 홀수라면 cnt 1 증가
            if (0 == check_even[end]) cnt++;

            // cnt가 k 초과라면, k 이하가 될 때까지 start를 1칸씩 증가
            while (cnt > k && start < end) {
                // start 위치의 값이 홀수라면 cnt 1 감소
                if (0 == check_even[start]) {
                    cnt--;
                }
                start = start + 1;
            } // while

            len = Math.max(len, end - start - cnt + 1);
            end++;
        } // while
        System.out.println(len);
        br.close();
    } // main
}

