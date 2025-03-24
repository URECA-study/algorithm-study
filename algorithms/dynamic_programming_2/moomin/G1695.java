package dynamic_programming_2.moomin;

import java.io.*;
import java.util.*;

public class G1695 {
    static int N;
    static int[] sequence;
    static int[] palindrome;
    static int[][] memo;

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 수열 입력받기
        sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // 판별하기
        memo = new int[N+1][N+1];
        palindrome = new int[N];
        for(int i = 0; i<N; i++){
            palindrome[i] = sequence[N-(i+1)];
        }

        for(int i = 0; i<N; i++){
            int count = 0;
            for(int j = 0; j<N; j++){
                if(sequence[i] == palindrome[j]){
                    memo[i+1][j+1] = memo[i][j] + 1;
                    count = memo[i+1][j+1];
                    continue;
                }
                memo[i+1][j+1] = Math.max(memo[i][j+1], count);
            }
        }
        System.out.println(N - memo[N][N]);
    }
}
