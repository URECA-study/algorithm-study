package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

public class Boj_16234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int l; static int r;
    static int n;

    public static boolean bfs(int i, int j) {
        visit[i][j] = true;
        queue.add(new int[] {i, j});
        List<int[]> union = new ArrayList<>();
        int sum = map[i][j];
        union.add(new int[] {i, j});

//        System.out.println(i + " " + j + "탐색 중");

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (isValid(ni, nj) && !visit[ni][nj]) {
                    int diff = Math.abs(map[ci][cj] - map[ni][nj]);
//                    System.out.println(i + ", " + j + "와 " + ni + ", " + nj + "의 diff = " + diff);
                    if (diff >= l && diff <= r) {
                        queue.offer(new int[] {ni, nj});
                        union.add(new int[] {ni, nj});
                        visit[ni][nj] = true;
                        sum += map[ni][nj];
                    }
                }
            } // 상하좌우 국가 탐색
        } // while

        // 인구 분배
        int avg = sum / union.size();
        for (int[] u : union) {
            map[u[0]][u[1]] = avg;
        }

        if (union.size() >= 2) return true;
        return false;
    } // bfs

    public static boolean isValid(int i, int j) {
        if (i >= 0 && j >= 0 && i < n && j < n) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) {
            visit = new boolean[n][n];
            boolean moved = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }
            if (!moved) break;
            count++;
        }

        System.out.println(count);

    } // main
}
