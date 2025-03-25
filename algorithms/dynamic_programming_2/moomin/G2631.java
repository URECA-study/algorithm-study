package dynamic_programming_2.moomin;

import java.io.*;
import java.util.*;

public class G2631 {

    static int N;
    static int[] arr;
    static int[] memo;
    static int notMove;
    public static void main(String[] args) throws IOException {

        // 아이들 수(N) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 아이들 입력받기
        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 시작
        memo = new int[N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] < arr[j]) continue;
                memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }

        // 움직이지 않아도 되는 아이 수 최댓값 구하기
        for(int m : memo){
            notMove = Math.max(notMove, m);
        }

        // 정답
        System.out.println(N - notMove);
    }
}
