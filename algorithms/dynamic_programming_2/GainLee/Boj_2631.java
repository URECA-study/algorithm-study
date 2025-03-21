package dynamic_programming_2.GainLee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_2631 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (lis.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right =  mid;
                    }
                } // while
                lis.set(left, num);
            } // if-else

        }

        System.out.println(n-lis.size());
    } // main
}