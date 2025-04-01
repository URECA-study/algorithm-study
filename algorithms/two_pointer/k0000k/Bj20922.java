package two_pointer.k0000k;

import java.io.*;
import java.util.*;

public class Bj20922 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int k;
    public static int[] nums;
    public static ArrayDeque<Integer> sequence = new ArrayDeque<>(); // 큐 처럼 사용
    public static HashMap<Integer, Integer> counter = new HashMap<>(); // 숫자의 갯수를 저장하는 해시맵

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (addPossible(num)) { // 덱에 넣을 수 있다면 넣기
                sequence.addLast(num);
                int past = counter.getOrDefault(num, 0);
                counter.put(num, past + 1);
                if (sequence.size() > maxLength) {
                    maxLength = sequence.size();
                }
                continue;
            }
            // 넣을 수 없다면, sequence.first에서 시작하는 수열은 더 볼 필요 없음.
            i--; // nums[i]를 다시한번 검사하기 위해 i 줄이기
            int pastKey = sequence.pollFirst();
            int past = counter.get(pastKey);
            // sequence.first 제거
            if (past - 1 == 0) {
                counter.remove(pastKey);
            }
            else {
                counter.put(pastKey, past - 1);
            }
        }

        System.out.println(maxLength);
    }

    // num이 추가 되었을 때, k개가 넘어가면 false
    private static boolean addPossible(int num) {
        if (!counter.containsKey(num)) {
            return true;
        }
        if (counter.get(num) == k) {
            return false;
        }
        return true;
    }
}
