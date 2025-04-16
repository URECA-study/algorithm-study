package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

// Boj_2206 벽 부수고 이동하기
public class Boj_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][][] visit;
    static int n; static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> queue = new LinkedList<>();

    public static class Node {
        int x;
        int y;
        int count;
        int wall;

        public Node (int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }

    public static int bfs (int x, int y) {
        visit[x][y][0] = true;
        visit[x][y][1] = true;
        queue.add(new Node(x, y, 1, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == n-1 && cur.y == m-1) return cur.count;
            int cx = cur.x ;
            int cy = cur.y;
            for (int d = 0; d < 4; d++) {;
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (isValid(nx, ny)){
                    if (map[nx][ny] == 0) {
                        if (visit[nx][ny][cur.wall] == false) {
                            queue.add(new Node (nx, ny, cur.count + 1, cur.wall));
                            visit[nx][ny][cur.wall] = true;
                        }
                    } else if (map[nx][ny] == 1) {
                        if (cur.wall == 0 && visit[nx][ny][1] == false) {
                            queue.add(new Node(nx, ny, cur.count + 1, 1));
                            visit[nx][ny][1] = true;
                        }
                    }
                }
            }
        } // while
        return -1;


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
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        } // map 입력

        visit = new boolean[n][m][2];
        System.out.println(bfs(0, 0));
    } // main
}
