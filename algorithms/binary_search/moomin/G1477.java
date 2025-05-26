package binary_search.moomin;

import java.io.*;
import java.util.*;

public class G1477 {
    static int N, M, L;
    static int ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 현재 휴게소
        arr = new int[N+2];
        arr[0] = 0;
        arr[1] = L;
        st = new StringTokenizer(br.readLine());
        for(int i = 2; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 휴게소 정렬
        Arrays.sort(arr);

        // new 휴게소 위치 탐색
        int left = 1;
        int right = L;
        while(left<=right){

            // mid 구하기
            int mid = (left+right) / 2;

            int count = 0;
            // mid 보다 작은 구간이 M개가 나오는지 확인
            for(int i = 1; i<arr.length; i++){
                int interval = arr[i] - arr[i-1];
                // 구간이 mid 보다 작거나 같으면 pass
                if(interval <= mid) continue;

                // 구간이 mid 보다 크면
                // mid가 즉 휴게소가 몇개가 들어갈 수 있는지 확인
                count += ((interval - 1) / mid);
                //System.out.println(interval/mid);
            }

            // count 가 M보다 크면
            if(count > M) {
                left = mid + 1;
                continue;
            }
            // count 가 M보다 작거나 같으면
            right = mid - 1;
            ans = mid;
        }
        System.out.println(left);
    }
}
