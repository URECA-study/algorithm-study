package binary_search.k0000k;

import java.io.*;
import java.util.*;

public class Bj20444 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // n = a + b 일때, (a + 1) * (b + 1) = k
        long left = 0;
        long right = n / 2;
        long mid = (left + right) / 2;
        while (left <= right) {
            long val = (mid + 1) * (n - mid + 1);
            if (val == k) {
                System.out.println("YES");
                return;
            }
            else if (val > k) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        System.out.println("NO");
    }
}
