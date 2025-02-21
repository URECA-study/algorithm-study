package data_structure2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_11286_2nd_try {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
        int abs_a = Math.abs(a);
        int abs_b = Math.abs(b);

        if (abs_a == abs_b)
            return a - b;
        else return abs_a - abs_b;
    });

    public static void main (String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {  // x가 0이라면 절대값이 가장 작은 값 출력 후 제거
                if (!absHeap.isEmpty()) {
                    System.out.println(absHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                absHeap.add(x);
            }
        } // for
        br.close();
    } // main
}
