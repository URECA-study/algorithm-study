package brute_force.GainLee;

import java.io.*;
import java.util.*;

public class Boj_21315 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] card;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        card = new int[n];
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            nums[i] = i+1;
        } // card 초기화

        int k;
        int i = 0;
        while (true) {
            if (card[n-1] == 1 || card[n-2] == 1) {
                break;
            }
            int[] new_card = new int[n];


        } //


        System.out.println();
    } // main
}