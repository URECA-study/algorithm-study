package dynamic_programming_1.moomin;

import java.io.*;
import java.util.*;

public class S11055 {

    static int N;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 수열 입력받기
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        memo = new int[N]; // 더해지는 최대값을 기록

        for (int i = 0; i < N; i++) {

            memo[i] = arr[i];
            if (i == 0) { continue; }

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + arr[i]);
                }
            }
        }

        // 정렬
        Arrays.sort(memo);

        // 최댓값 출력
        System.out.println(memo[N - 1]);
    }
}
