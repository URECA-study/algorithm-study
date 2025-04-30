package simulation.k0000k;

import java.io.*;
import java.util.*;

public class Bj15683 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static int[][] office;
    public static ArrayList<int[]> nodes = new ArrayList<>();
    public static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] > 0 && office[i][j] < 6) {
                    nodes.add(new int[]{i, j, office[i][j]});
                }
            }
        }

        traverse(0, office);
        System.out.println(answer);
    }

    private static void traverse(int cnt, int[][] arr) {
        if (cnt >= nodes.size()) { // 종료시에는 사각지대의 갯수 카운트
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        result += 1;
                    }
                }
            }
            answer = Math.min(answer, result);
            return;
        }

        int[] node = nodes.get(cnt);
        int val = node[2];
        int x = node[0];
        int y = node[1];
        if (val == 1) {
            for (int[] dir : directions) { // 한 방향으로만 이동
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, dir);
                traverse(cnt + 1, afterOffice);
            }
        }
        else if (val == 2) {
            for (int i = 0; i < 2; i++) { // 서로 다른 180도 방향으로 이동
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, directions[i]);
                move(x, y, afterOffice, directions[i + 2]);
                traverse(cnt + 1, afterOffice);
            }
        }
        else if (val == 3) {
            for (int i = 0; i < 4; i++) { // 수직 방향으로 이동
                int[][] afterOffice = copyArr(arr);
                move(x, y, afterOffice, directions[i]);
                move(x, y, afterOffice, directions[(i + 1) % 4]);
                traverse(cnt + 1, afterOffice);
            }
        }
        else if (val == 4) {
            for (int i = 0; i < 4; i++) { // 각각 하나의 방향만 제외하고 3방향 이동
                int[][] afterOffice = copyArr(arr);
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        continue;
                    }
                    move(x, y, afterOffice, directions[j]);
                }
                traverse(cnt + 1, afterOffice);
            }
        }
        else { // 모든 방향으로 이동
            int[][] afterOffice = copyArr(arr);
            for (int i = 0; i < 4; i++) {
                move(x, y, afterOffice, directions[i]);
            }
            traverse(cnt + 1, afterOffice);
        }
    }

    // 유효한 범위인지 확인
    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < office.length) && (y >= 0) && (y < office[0].length);
    }

    // 배열 깊은 복사
    private static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return newArr;
    }

    // (x, y)에서 dir 방향으로 가능한만큼 계속 이동
    private static void move(int x, int y, int[][] afterOffice, int[] dir) {
        while (isRange(x, y)) {
            if (afterOffice[x][y] == 0) {
                afterOffice[x][y] = -1;
            }
            else if (afterOffice[x][y] == 6) {
                break;
            }
            x += dir[0];
            y += dir[1];
        }
    }
}
