package data_structure2.moomin;

import java.io.*;
import java.util.*;

/**
 * 예전에 한번 풀었던 적이 있는 문제!
 * 다시 풀어봐도 절댓값 중심으로 정렬을 재정의하는 건 헷갈린다..!
 */

public class S11286 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    // 우선순위 큐 정렬기준 다시 정의
    static PriorityQueue<Integer> priorityQ = new PriorityQueue<>((o1, o2) ->
    {
        if(Math.abs(o1) == Math.abs(o2)){ // 같으면 음수 우선
            return o1 - o2;
        }
        return Math.abs(o1) - Math.abs(o2); // 다르면 절댓값 기준 작은 것
    });

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                priorityQ.add(num);
                continue;
            }
            if (priorityQ.isEmpty() && num == 0) {
                sb.append(0).append('\n');
                continue;
            }
            sb.append(priorityQ.poll()).append('\n');
        }

        System.out.println(sb.toString().trim());
    }
}
