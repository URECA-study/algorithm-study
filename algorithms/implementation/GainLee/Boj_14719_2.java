package implementation.GainLee;

import java.io.*;
import java.util.*;

public class Boj_14719_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w;
    static int[] blocks;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        blocks = new int[w+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        } // for - 입력


        int start = 1;
        int end = w;
        int sum = 0;

        // 양쪽이 막혀있을 때까지 start, end 옮기기
        while (blocks[start] == 0 || blocks[end] == 0) {
            if (blocks[start] == 0) start++;
            if (blocks[end] == 0) end--;
            if (start >= end) break;
        }

        int start_max = blocks[start];
        int end_max = blocks[end];

        while (start < end){
            // start위치와 end위치의 높이를 비교하고, 낮은 쪽을 이동하면서 차이를 더한다.
            if (start_max <= end_max) {
                start++;
                start_max = Math.max(blocks[start], start_max);
                sum += start_max - blocks[start];
            } else {
                end--;
                end_max = Math.max(blocks[end], end_max);
                sum += end_max - blocks[end];
            }
        } // while

        System.out.println(sum);
    } // main
}
