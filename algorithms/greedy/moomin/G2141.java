package greedy.moomin;

import java.io.*;
import java.util.*;
public class G2141 {

    static int N;
    static int[] village;
    static long postSpot = 0;
    static long peopleSum = 0;
    static PriorityQueue<int[]> arr = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    public static void main(String[] args) throws IOException{

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 마을, 인구수 입력
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            peopleSum += a;
            arr.add(new int[]{x, a});
        }

        // 정렬된 마을 기준으로 탐색
        // 중앙으로 갈 수록 거리의 합이 작아짐
        // 인구를 함께 고려할때 우체국 왼/오 인구수 비율이 맞아야함
        village = new int[2];
        for(int i = 0; i<N; i++){
            village = arr.poll();
            postSpot += village[1];
            if(postSpot >= (peopleSum/2.0)){
                System.out.println((peopleSum/2.0));
                System.out.println(village[0]);
                break;
            }
        }
    }
}
