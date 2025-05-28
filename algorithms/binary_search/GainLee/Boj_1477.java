package binary_search.GainLee;

import java.io.*;
import java.util.*;

public class Boj_1477 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; static int m; static int length;
    static int[] rest_spot;

    static boolean isRestSpot(int mid) {
        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            int gap = rest_spot[i] - rest_spot[i-1];
            cnt += (gap-1) / mid;
        }
        if (cnt > m) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        rest_spot = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            rest_spot[i] = Integer.parseInt(st.nextToken());
        }
        rest_spot[0] = 0;
        rest_spot[n+1] = length;

        Arrays.sort(rest_spot);

        int left = 0;
        int right = length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isRestSpot(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } // while

        System.out.println(left);

    } // main
}
