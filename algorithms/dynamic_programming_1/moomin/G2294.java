package dynamic_programming_1.moomin;

import java.io.*;
import java.util.*;

public class G2294 {

    static int N, K;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 가치 입력받기
        arr = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 시작
        // Min(memo[현재 값 - 비교값]이 유효하면 + 1)
        memo = new int[K+1];

        // 모두 최댓값으로 set
        for(int i = 1; i<=K; i++){
            memo[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<=K; i++) {
            for (int j = 0; j < N; j++) {

                // 현재 값에서 비교값을 사용했을때 0보다 작다면
                if (i - arr[j] < 0) continue;

                // 현재 값에서 비교값을 사용 후 남은 값을 만들 수 없다면
                if (memo[i - arr[j]] == Integer.MAX_VALUE) continue;

                // 현재 값을 비교하고 남은 값을 만드는 최소 경우
                memo[i] = Math.min(memo[i], memo[i - arr[j]] + 1);
            }
        }

        // 정답
        if(memo[K]+1 < 0){
            System.out.println(-1);
            return;
        }
        System.out.println(memo[K]);
    }
}
