package greedy.GainLee;

import java.io.*;
import java.util.*;

public class Boj_8980 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> delivery = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int total = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            delivery.add(new int[]{from, to , box});
        } // for

        delivery.sort(Comparator.comparingInt(a -> a[1]));

        int[] truck = new int[n+1];

        for (int[] del : delivery) {
            int from = del[0];
            int to = del[1];
            int box = del[2];

            int maxSpace = c;
            for (int i = from; i < to ; i++) {
                maxSpace = Math.max(maxSpace, c - truck[i]);
                System.out.println(maxSpace);
            }

            int loadableBox = Math.min(maxSpace, box);

            for (int i = from; i < to; i++) {
                truck[i] += loadableBox;
            }

            total += loadableBox;
        }

        System.out.println(total);
        br.close();
    } // main
}
