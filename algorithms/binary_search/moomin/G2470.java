package binary_search.moomin;

import java.io.*;
import java.util.*;

public class G2470 {
    static int N;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;
    static int[] ansSolution = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 입력받기
        N = Integer.parseInt(st.nextToken());

        // 용액 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 ex. -99 -2 -1 4 98
        Arrays.sort(arr);

        // 탐색 시작
        // 가장 작은 수와 가장 큰수를 더한값의 절대값을 비교
        int left = 0;
        int right = arr.length-1;

        while(left < right){

            int mix = Math.abs(arr[left] + arr[right]);
            if(mix < ans) {
                ans = mix;
                ansSolution[0] = arr[left];
                ansSolution[1] = arr[right];
            }

            // 포인터 이동
            // 같으면 왼,오 이동
            if(arr[left] == arr[right]){
                left++;
                right--;
                continue;
            }

            // 오른쪽 감소 vs 왼쪽 증가
            if(Math.abs(arr[left] + arr[right-1]) <  Math.abs(arr[left+1] + arr[right])){
                right--;
                continue;
            }

            left++;
        }

        System.out.println(ansSolution[0] + " " + ansSolution[1]);
    }
}
