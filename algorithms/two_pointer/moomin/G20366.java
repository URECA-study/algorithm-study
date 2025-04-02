package two_pointer.moomin;

import java.io.*;
import java.util.*;

public class G20366 {

    static int N;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // N입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 눈덩이 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        for(int i = 0; i<=N-4; i++){
            for(int j = N-1; j>= i+3; j--){
                int elsa = arr[i] + arr[j];
                int left = i+1;
                int right = j-1;

                while(left < right){
                    int anna = arr[left] + arr[right];
                    ans = Math.min(ans, Math.abs(elsa - anna));
                    if(anna < elsa) {
                        left++;
                        continue;
                    }

                    if(anna > elsa) {
                        right--;
                        continue;
                    }
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}

