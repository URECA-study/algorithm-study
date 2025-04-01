package two_pointer.moomin;

import java.io.*;
import java.util.*;

public class S21921 {
    static int N, X;
    static int maxVisit;
    static int[] visitants;
    static TreeMap<Integer, Integer> ans = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        // N과 X입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 방문자 수 입력받기
        visitants = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            visitants[i] = Integer.parseInt(st.nextToken());
            if(i < X) {
                maxVisit += visitants[i];
            }
        }

        // 탐색 시작
        int start = 0;
        int end = X;
        ans.put(maxVisit, 1);
        while(end < N){
            maxVisit += visitants[end++];
            maxVisit -= visitants[start++];

            if(ans.containsKey(maxVisit)) {
                ans.put(maxVisit, ans.get(maxVisit)+1);
                continue;
            }
            ans.put(maxVisit, 1);
        }

        if(ans.lastKey() == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(ans.lastKey());
        System.out.println(ans.get(ans.lastKey()));
    }
}
