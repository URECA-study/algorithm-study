package two_pointer.k0000k;

import java.io.*;
import java.util.*;

public class Bj22862 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] nums;
    public static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            // 홀짝 여부만 표시
            nums[i] = Integer.parseInt(st.nextToken()) % 2;
        }

        int answer = 0;
        int[] cnts = new int[2];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) { // 0이면 바로 넣기
                queue.addLast(0);
                cnts[0]++;
            }
            else if (nums[i] == 1) { // 1일 때는 k개보다 작을때만 넣기
                if (cnts[1] < k) {
                    queue.addLast(1);
                    cnts[1]++;
                }
                else {
                    i--; // i번째 숫자를 다시 검사하기 위해 1 줄이기
                    int val = queue.pollFirst(); // 큐의 첫 번째 숫자 삭제
                    cnts[val]--;
                }
            }
            // (수열의 전체 길이) - (홀수의 갯수)가 짝수 수열의 갯수
            if (queue.size() - cnts[1] > answer) {
                answer = queue.size() - cnts[1];
            }
        }
        System.out.println(answer);
    }
}
