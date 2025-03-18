package dynamic_programming_1.moomin;

import java.io.*;
import java.util.*;

public class S2579 {

    static int N;
    static int score;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        // N 입력받기(계단 수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 계단 입력받기
        arr = new int[N+1];
        arr[0] = 0;
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 계단 올라가기
        memo = new int[N+1];

        // 3층부터 최댓값 찾기
        // 현재까지 최대 = max(나의 전전, 나의 전+나의전전전) + 나
        for(int i = 0; i<arr.length; i++){
            // 2층까지는 최적값 세팅
            if(i < 3){
                memo[i] = arr[i] + score;
                score += arr[i];
                continue;
            }
            score = Math.max(memo[i-2], (arr[i-1] + memo[i-3])) + arr[i];
            memo[i] = score;
        }
        System.out.println(score);
    }
}
