package data_structure2.k0000k;

import java.io.*;
import java.util.*;

public class Bj11279 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(-1 * pq.poll());
            }
            else {
                pq.add(-num);
            }
        }
    }
}
