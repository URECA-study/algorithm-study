package data_structure2.moomin;

import java.io.*;
import java.util.*;

/**
 * 리스트의 정렬기준을 내림차순으로 제정의하고자 number 클래스를 만들었지만
 * 우선순위 큐를 사용하면 그럴 필요가 없다는 것을 깨닫고 이를 활용함!
 */

public class S11279 {

    static int N;

    // 내림차순 정렬
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 반복해서 수 입력받기
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > 0){
                priorityQueue.add(num);
                continue;
            }

            if(priorityQueue.isEmpty() && num == 0 ){
                sb.append(0).append('\n');
                continue;
            }

            sb.append(priorityQueue.poll()).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
