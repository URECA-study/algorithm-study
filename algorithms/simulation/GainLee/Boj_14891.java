package simulation.GainLee;

import java.io.*;
import java.util.*;

public class Boj_14891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> circles = new ArrayList<>();
    static boolean[] visited;

    static void move(int num, int direction, boolean[] visited) {
        visited[num] = true;

        // 왼쪽 톱니바퀴
        if (num > 0 && !visited[num-1]) {
            // 극이 다르다면 num - 1 회전 방향의 반대 방향으로 회전
            if (circles.get(num-1).get(2) != circles.get(num).get(6)) {
                move(num-1, -direction, visited);
            }
        }
        // 오른쪽 톱니바퀴
        if (num < 3 && !visited[num+1]) {
            // 극이 다르다면 num + 1 회전 방향의 반대 방향으로 회전
            if (circles.get(num+1).get(6) != circles.get(num).get(2)) {
                move(num+1, -direction, visited);
            }
        }

        Collections.rotate(circles.get(num), direction);
    } // move

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> gear = new ArrayList<>();
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gear.add(line[j] - '0');
            }
            circles.add(gear);
        } //

        int T = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[4];
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            move(num-1, dir, visited);
        }

        for (int i = 0; i < 4; i++) {
            if (circles.get(i).get(0) == 1) {
                sum += (int) Math.pow(2, i);
            }
        }

        System.out.println(sum);
    } // main
}
