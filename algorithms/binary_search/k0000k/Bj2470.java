package binary_search.k0000k;

import java.io.*;
import java.util.*;

class Liquid implements Comparable<Liquid> {
    int val;
    int abs;

    public Liquid(int val) {
        this.val = val;
        this.abs = Math.abs(val);
    }

    @Override
    public int compareTo(Liquid o) { // 절댓값 기준으로 정렬
        if (this.abs == o.abs) {
            return this.val - o.val;
        }
        return this.abs - o.abs;
    }
}

public class Bj2470 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Liquid[] liquids;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        liquids = new Liquid[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = new Liquid(Integer.parseInt(st.nextToken()));
        }

        // 절댓값이 가장 가까운 값을 더한것만 최솟값의 후보가 된다.
        Arrays.sort(liquids);

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n - 1; i++) { // 인접한 값만 확인한다.
            int sum = Math.abs(liquids[i].val + liquids[i + 1].val);
            if (sum < min) {
                min = sum;
                idx = i;
            }
        }

        int val1 = liquids[idx].val;
        int val2 = liquids[idx + 1].val;

        System.out.println(Math.min(val1, val2) + " " + Math.max(val1, val2));
    }
}
