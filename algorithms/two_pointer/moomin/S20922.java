package two_pointer.moomin;

import java.io.*;
import java.util.*;

public class S20922 {
    static int N, K;
    static int[] arr;
    static int ans;
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수열 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        int start = 0;
        int end = 0;

        // 초기 탐색
        while(end < N){
            if(map.containsKey(arr[end])){
                if(map.get(arr[end]) + 1 > K){
                    ans = Math.max(ans, end-start);
                    while(true){
                        if(arr[start] == arr[end]){
                            start++;
                            end++;
                            break;
                        }
                        map.put(arr[start], map.get(arr[start]) - 1);
                        start++;
                    }
                    continue;
                }
                map.put(arr[end], map.get(arr[end])+1);
                end++;
                continue;
            }
            map.put(arr[end++], 1);
        }
        ans = Math.max(ans, end-start);
        System.out.println(ans);
    }
}
