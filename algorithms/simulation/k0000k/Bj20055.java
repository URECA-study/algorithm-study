package simulation.k0000k;

import java.io.*;
import java.util.*;

public class Bj20055 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] belts;
    public static int start = 0;
    public static int cnt = 0;
    public static boolean[] top;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        belts = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belts[i] = Integer.parseInt(st.nextToken());
        }

        top = new boolean[n];
        int phase = 0;
        while (cnt < k) {
            phase++;
            // 벨트 1번 회전
            start = isBeltRange(start - 1);
            for (int i = top.length - 2; i >= 0; i--) {
                if (top[i]) {
                    top[i] = false;
                    top[i + 1] = true;
                }
            }

            // 회전했는데 내리는 위치에 로봇 있으면 내리기
            top[top.length - 1] = false;

            // 로봇 이동
            for (int i = top.length - 2; i >= 0; i--) {
                int beltIdx = isBeltRange(start + i + 1);
                if (top[i] && !top[i + 1] && belts[beltIdx] > 0) {
                    top[i] = false;
                    top[i + 1] = true;
                    belts[beltIdx] -= 1;
                    if (belts[beltIdx] == 0) {
                        cnt++;
                    }
                }
            }

            // 로봇 이동 후 내리는 위치에 로봇 있으면 내리기
            top[top.length - 1] = false;

            // 올리는 곳에 새로운 로봇 올리기
            if (belts[start] > 0) {
                top[0] = true;
                belts[start] -= 1;
                if (belts[start] == 0) {
                    cnt++;
                }
            }
        }
        System.out.println(phase);
    }

    public static int isBeltRange(int idx) {
        if (idx < 0) {
            return idx + belts.length;
        }
        else if (idx >= belts.length) {
            return idx - belts.length;
        }
        return idx;
    }

}
