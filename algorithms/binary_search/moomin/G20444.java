package binary_search.moomin;

import java.io.*;
import java.util.*;

/**
 *  4번의 가위질로 9개의 조각 만들기
 *  1. 색종이는 직사각형이며, 색종이를 자를 때는 한 변에 평행하게 자른다.
 *  2. 자르기 시작했으면, 경로 상의 모든 색종이를 자를 때까지 멈추지 않는다.
 *  3. 이미 자른 곳을 또 자를 수 없다.
 *
 *  이분탐색: 가로 * 세로 = 색종이 조각
 */

public class G20444 {
    static long N, K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, K 입력받기
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        // 가로 * 세로
        long left = 0;
        long right = N;
        long count;

        while(left <= right){

            long mid = (left + right) / 2;

            // 색종이 만들 수 있는지 탐색
            count = (mid + 1) *  ((N - mid) + 1);

            if(count == K) {
                System.out.println("YES");
                return;
            }

            if(count > K) {
                right = mid  - 1;
                continue;
            }
            left = mid  + 1;
        }
        System.out.println("NO");
    }
}



