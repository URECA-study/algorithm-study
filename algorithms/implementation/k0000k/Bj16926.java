package implementation.k0000k;

import java.io.*;
import java.util.*;

public class Bj16926 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] nums;
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[n][m];
        int rectCnt = Math.min(n, m) / 2; // 사각형의 갯수
        int rectLength = (n + m - 2) * 2; // 사각형의 둘레
        // 바깥에서 i번째 사각형에 대해 돌리기
        for (int i = 0; i < rectCnt; i++) {
            int moveCnt = r % rectLength; // i번째 사각형의 회전 횟수
            // 사각형의 세로 변 이동
            for (int j = i; j < nums.length - i; j++) {
                rotate(j, i, i, moveCnt); // 왼쪽 변
                rotate(j, m - 1 - i, i, moveCnt); // 오른쪽 변
            }
            // 사각형의 가로 변 이동
            for (int j = i; j < nums[0].length - i; j++) {
                rotate(i, j, i, moveCnt); // 윗쪽 변
                rotate(n - 1 - i, j, i, moveCnt); // 아랫쪽 변
            }
            rectLength -= 8; // 안쪽 사각형은 바깥쪽 사각형과 둘레 차이가 8이다.
        }

        printAnswer();
    }

    // (x, y)의 이동 후 좌표를 찾아서 answer 배열에 값을 집어넣기
    private static void rotate(int x, int y, int i, int cnt) {
        int pastVal = nums[x][y];
        int currentCnt = 0; // 이동횟수 -> cnt번이 될 때까지
        int startX = i; // i번째 사각형의 왼쪽 윗 점
        int startY = i;
        int endX = nums.length - 1 - i; // i번째 사각형의 오른쪽 아랫 점
        int endY = nums[0].length - 1 - i;
        // cnt 번 이동했을 때의 좌표를 구하기
        while (currentCnt < cnt) {
            if (x < endX && y == startY) { // 아래로 이동
                x++;
                currentCnt++;
            }
            else if (y < endY && x == endX) { // 오른쪽으로 이동
                y++;
                currentCnt++;
            }
            else if (x > startX && y == endY) { // 위로 이동
                x--;
                currentCnt++;
            }
            else { // 왼쪽으로 이동
                y--;
                currentCnt++;
            }
        }
        answer[x][y] = pastVal; // answer 배열에 값 넣기
    }

    private static void printAnswer() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
