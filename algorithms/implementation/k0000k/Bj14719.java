package implementation.k0000k;

import java.io.*;
import java.util.*;

public class Bj14719 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] blocks;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        for (int height = h; height >= 0; height--) {
            int val = -1;
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] >= height) {
                    if (val == -1) { // height를 처음 만났을때
                        val = i;
                        continue;
                    }
                    result += (i - val - 1); // 이전에 만난 height와의 거리를 계산하고, result에 더하기
                    val = i;
                }
            }
        }
        System.out.println(result);
    }
}
