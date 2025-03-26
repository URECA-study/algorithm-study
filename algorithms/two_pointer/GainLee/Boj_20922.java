package two_pointer.GainLee;

import java.io.*;
import java.util.*;

public class Boj_20922 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Integer> frq_arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input_arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input_arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = 0;
        frq_arr = new HashMap<>();

        while (end < n) {
            int cur = input_arr[end];
            frq_arr.put(cur, frq_arr.getOrDefault(cur, 0) + 1);

            while (frq_arr.get(cur) > k) {
                int left = input_arr[start];
                frq_arr.put(left, frq_arr.get(left) - 1);
                start++;
            }

            len = Math.max(len, end - start + 1);
            end++;
        } // for

        System.out.println(len);
    } // main
}
