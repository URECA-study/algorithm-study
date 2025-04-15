package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

// Boj_2206 벽 부수고 이동하기
public class Boj_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int n; static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] new_map; // 거리 저장용 map
    static Queue<int[]> queue = new LinkedList<>();

    public static void bfs (int x, int y) {
        visit[x][y] = true;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int d = 0; d < 4; d++) {;
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (isValid(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    new_map[nx][ny] += 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        } // while


    } // bfs

    public static boolean isValid (int x, int y) {
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
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        } // map 입력

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

    } // main
}
