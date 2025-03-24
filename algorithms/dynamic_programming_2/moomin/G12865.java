package dynamic_programming_2.moomin;

import java.io.*;
import java.util.*;

public class G12865 {

    static int N, K, W, V;
    static int[][] bag;
    static long[] memo;
    public static void main(String[] args) throws IOException {

        // N과 K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 짐 + 가치 입력받기
        bag = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            bag[i][0] = W;
            bag[i][1] = V;
        }

        // 탐색 시작
        memo = new long[K+1];

        for(int b = 0; b<N; b++) {
            for(int i = K; i >= bag[b][0]; i--){
                memo[i] = Math.max(memo[i], memo[i - bag[b][0]] + (long) bag[b][1]);
            }
        }
        System.out.println(memo[K]);
    }
}
