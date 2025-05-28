package binary_search.GainLee;

import java.io.*;
import java.util.*;

public class Boj_20444 {
    // 색종이 자르기
    // 조각의 수 = (세로로 자른 횟수 + 1) + (가로로 자른 횟수 + 1)
    static long cut(long row, long col) {
        return (row + 1) * (col + 1);
    } // cut

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 가위질
        long k = Long.parseLong(st.nextToken()); // 종이 조각

        long left = 0;
        long right = n / 2;

        while (left <= right) {
            long row = (left + right) / 2;
            long col = n - row;

            long total = cut(row, col);
            if (total == k) {
                System.out.println("YES");
                return;
            } else if (total > k) {
                // row 와 col의 차이가 커야함.
                right = row - 1;
            } else if (total < k) {
                left = row + 1;
            }
        }
        System.out.println("NO");

    } // main

}