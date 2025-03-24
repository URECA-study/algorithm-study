package dynamic_programming_2.moomin;

import java.io.*;
import java.util.*;

public class S15724 {

    static int N, M, K;
    static long[][] arr;
    static int x1, y1, x2, y2;
    static long ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N, M (땅크기) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 땅 입력받기 --> 입력받으면서 사람 수 누적하여 기록하기
        arr = new long[N+1][M+1];

        // 좌표랑 헷갈리지 않도록 인덱스 1부터 기록
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=M; j++){
                arr[i][j] = Long.parseLong(st.nextToken()) + arr[i][j-1];
            }
        }

        // K 입력받기
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // 땅 탐색
        while(K-->0){

            // x1, y1, x2, y2 입력받기 -> 헷갈림 이슈로 변수는 arr에 맞춰서 수정
            st = new StringTokenizer(br.readLine());

            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            // y범위 만큼 x범위의 누적합을 계산
            for(int i = y1; i<=y2; i++){
                ans += arr[i][x2] - arr[i][x1-1];
            }

            sb.append(ans).append('\n');
            ans = 0;
        }
        System.out.println(sb.toString().trim());
    }
}

