package two_pointer.k0000k;

import java.io.*;
import java.util.*;

public class Bj21921 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] visitors;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        visitors = new int[n];
        for (int i = 0; i < n; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += visitors[i];
        }

        int cnt = 1;
        int maxSum = sum;
        int startIdx = 0;
        for (int i = x; i < n; i++) {
            sum = sum + visitors[i] - visitors[startIdx];
            if (sum == maxSum) {
                cnt++;
            }
            else if (sum > maxSum) {
                cnt = 1;
                maxSum = sum;
            }
            startIdx++;
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }
}
