package dynamic_programming_1.moomin;

import java.io.*;
import java.util.*;

public class S9465 {
    static int N;
    static int T;
    static int arr[][];
    static int memo[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // n 만큼 반복
        for(int n = 0; n<N; n++) {

            // T 입력받기
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());

            // 스티커 입력받기
            arr = new int[2][T];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            // 탐색
            memo = new int[2][T];
            for (int i = 0; i < T; i++) {
                // 두번째까지는 그냥 더하기
                if (i == 0) {
                    memo[0][i] = arr[0][i];
                    memo[1][i] = arr[1][i];
                    continue;
                }

                if (i == 1) {
                    memo[0][i] = arr[0][i] + arr[1][i - 1];
                    memo[1][i] = arr[1][i] + arr[0][i - 1];
                    continue;
                }

                memo[0][i] = Math.max(memo[1][i - 1], memo[1][i - 2]) + arr[0][i];
                memo[1][i] = Math.max(memo[0][i - 1], memo[0][i - 2]) + arr[1][i];
            }
            sb.append(Math.max(memo[0][T - 1], memo[1][T - 1])).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}

