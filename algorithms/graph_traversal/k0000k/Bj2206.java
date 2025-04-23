package graph_traversal.k0000k;

import java.io.*;
import java.util.*;

class Path {
    int val;
    int wall;
    int x;
    int y;

    public Path(int val, int wall, int x, int y) {
        this.val = val;
        this.wall = wall;
        this.x = x;
        this.y = y;
    }
}

public class Bj2206 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String[][] board;
    public static Path[][][] visited;
    public static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            board[i] = input;
        }

        visited = new Path[n][m][2];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = new Path(Integer.MAX_VALUE, k, i, j);
                }
            }
        }

        ArrayDeque<Path> queue = new ArrayDeque<>();
        int val = Integer.parseInt(board[0][0]);
        Path start = new Path(1, val, 0, 0);
        queue.addLast(start);
        visited[0][0][val] = start;

        while (!queue.isEmpty()) {
            Path pastPath = queue.pollFirst();
            if (pastPath.x == n - 1 && pastPath.y == m - 1) {
                System.out.println(pastPath.val);
                return;
            }

            for (int[] dir : directions) {
                int x = pastPath.x + dir[0];
                int y = pastPath.y + dir[1];
                if (isRange(x, y) && isUpdate(x, y, pastPath)) {
                    if (board[x][y].equals("0")) { // 이동 하려는 칸이 0
                        Path newPath = new Path(pastPath.val + 1, pastPath.wall, x, y);
                        visited[x][y][pastPath.wall] = newPath;
                        queue.addLast(newPath);
                    }
                    else if (pastPath.wall == 0) { // 이동 하려는 칸이 1이면서, 지금까지 부순 벽이 없음
                        Path newPath = new Path(pastPath.val + 1, pastPath.wall + 1, x, y);
                        visited[x][y][1] = newPath;
                        queue.addLast(newPath);
                    }
                }
            }
        }
        System.out.println(-1);
    }

    // 기존보다 유리한 경로일때만 갱신 -> 갱신이 이루어지는지 확인
    private static boolean isUpdate(int x, int y, Path oldPath) {
        int isWall = Integer.parseInt(board[x][y]);
        if (isWall + oldPath.wall < 2) { // 벽을 두번 부술수는 없음
            Path destPath = visited[x][y][isWall + oldPath.wall];
            return oldPath.val + 1 < destPath.val; // 새로운 경로가 더 짧다면 true
        }
        return false;
    }

    // (x, y)가 범위 내부인지 확인
    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < board.length) && (y >= 0) && (y < board[0].length);
    }
}
