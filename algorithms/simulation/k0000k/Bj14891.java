package simulation.k0000k;

import java.io.*;
import java.util.*;

class Cycle {
    public int[] data;
    public int top = 0; // 12시 방향이 가리키는 극

    public Cycle(int[] data) {
        this.data = data;
    }
}

public class Bj14891 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static Cycle[] cycles;

    public static void main(String[] args) throws IOException {
        cycles = new Cycle[4];
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            int[] nums = new int[8];
            for (int j = 0; j < 8; j++) {
                nums[j] = Integer.parseInt(input[j]);
            }
            cycles[i] = new Cycle(nums);
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rotate(n - 1, d);
        }

        int score = calculateScore();
        System.out.print(score);
    }

    private static void rotate(int n, int d) {
        int left = n;
        int right = n;
        ArrayList<int[]> leftInfo = new ArrayList<>();
        ArrayList<int[]> rightInfo = new ArrayList<>();
        int leftWay = d;
        int rightWay = d;

        // n번째 톱니바퀴를 돌렸을 때 영향 받는 왼쪽 톱니바퀴를 모두 탐색
        while (left - 1 >= 0 && checkDifferent(left, -1)) {
            left--;
            leftWay *= -1;
            leftInfo.add(new int[]{left, leftWay});
        }

        // n번째 톱니바퀴를 돌렸을 때 영향 받는 오른쪽 톱니바퀴를 모두 탐색
        while (right + 1 <= 3 && checkDifferent(right, 1)) {
            right++;
            rightWay *= -1;
            rightInfo.add(new int[]{right, rightWay});
        }

        // 회전을 바로바로 반영하지 않고, 마지막에 한 번에 반영
        applyRotate(leftInfo); // 왼쪽 톱니바퀴들 top 업데이트
        applyRotate(rightInfo); // 오른쪽 톱니바퀴들 top 업데이트

        // n번째 톱니바퀴 top 업데이트
        cycles[n].top = checkRange(cycles[n].top - d);
    }

    // n번째 톱니바퀴와 왼쪽(-1) 또는 오른쪽(1) 톱니바퀴가 다른지 확인
    private static boolean checkDifferent(int n, int d) {
        int edge = checkRange(cycles[n].top + 2 * d);
        int otherEdge = checkRange(cycles[n + d].top - 2 * d);

        if (cycles[n].data[edge] != cycles[n + d].data[otherEdge]) {
            return true;
        }

        return false;
    }

    // 회전 배열 인덱스 범위 체크
    private static int checkRange(int edge) {
        if (edge < 0) {
            edge += 8;
        } else if (edge > 7) {
            edge -= 8;
        }
        return edge;
    }

    // 회전 반영
    private static void applyRotate(ArrayList<int[]> info) {
        for (int[] array: info) {
            int temp = cycles[array[0]].top - array[1];
            cycles[array[0]].top = checkRange(temp);
        }
    }

    // 최종 점수 계산
    private static int calculateScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            int idx = cycles[i].top;
            if (cycles[i].data[idx] == 1) {
                score += Math.pow(2, i);
            }
        }
        return score;
    }

}
