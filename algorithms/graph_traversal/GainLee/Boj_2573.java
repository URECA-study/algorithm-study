package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; static int m;
    static int[][] map;
    static int[][] new_map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int years = 0;

    static void bfs (int x, int y) {
        visited[x][y] = true;
        queue.offer(new int[] {x, y});
        new_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                new_map[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            visited[cx][cy] = true;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(!visited[nx][ny] && isValid(nx, ny) && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
                if (isValid(nx, ny) && map[nx][ny] == 0) {
                    new_map[cx][cy]--;
                    if (new_map[cx][cy] < 0) new_map[cx][cy] = 0;
                }
            }
        }

        map = new_map;

    }

    static boolean isValid (int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    } // isValid

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
         map = new int[n][m];
        new_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cnt = 0;
            visited = new boolean[n][m];
            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if (!visited[i][j] && map[i][j] != 0){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                break;
            }
            if (cnt > 1) {
                System.out.println(years);
                break;
            }
            years++;

        }
    } // main
}
