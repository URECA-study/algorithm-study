package data_structure2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_11279 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    // 가장 큰 수 출력 후 제거
                    System.out.println(maxHeap.poll());
                }
            }  else {
                maxHeap.add(x);
            }

        } // for
        br.close();
    } // main
}