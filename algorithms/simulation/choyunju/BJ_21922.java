import java.io.*;
import java.util.*;

class BJ_21922 {
    static int N, M, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> air;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        count = 0;
        air = new ArrayList<>();
        int x=0, y = 0;
        for(int i=0; i<N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                // 에어컨인 경우
                if(map[i][j] == 9) {
                    air.add(new int[] {i, j});
                }
            }
        }
        for(int[] n : air) {
            x = n[0];
            y = n[1];
            top(x, y);
            left(x, y);
            right(x, y);
            down(x, y);
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void top(int i, int j) {
        visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0]-1;
            int y = now[1];

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }

            // 물건이 없는 경우
            if(map[x][y] == 0) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 1인 경우 바람은 그대로 위쪽 방향 유지
            else if(map[x][y] == 1) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 2인 경우
            else if(map[x][y] == 2) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
            }
            // 물건 3인 경우 바람이 오른쪽으로 이동
            else if(map[x][y] == 3) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                right(x, y);
            }
            // 물건 4인 경우 바람이 왼쪽으로 이동
            else if(map[x][y] == 4) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                left(x, y);
            }
        }
    }

    public static void right(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1]+1;

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }
            // 물건이 없는 경우
            if(map[x][y] == 0) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 1인 경우
            else if(map[x][y] == 1) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
            }
            // 물건 2인 경우 바람이 그대로 유지
            else if(map[x][y] == 2) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 3인 경우 바람이 위쪽으로 이동
            else if(map[x][y] == 3) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                top(x, y);
            }
            // 물건 4인 경우 바람이 아래쪽으로 이동
            else if(map[x][y] == 4) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                down(x, y);
            }
        }
    }

    public static void down(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0]+1;
            int y = now[1];

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }
            // 물건이 없는 경우
            if(map[x][y] == 0) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 1인 경우 바람이 그대로 유지
            else if(map[x][y] == 1) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 2인 경우
            else if(map[x][y] == 2) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
            }
            // 물건 3인 경우 바람이 왼쪽으로 이동
            else if(map[x][y] == 3) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                left(x, y);
            }
            // 물건 4인 경우 오른쪽으로 이동
            else if(map[x][y] == 4) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                right(x, y);
            }
        }
    }

    public static void left(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1]-1;

            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }
            // 물건이 없는 경우
            if(map[x][y] == 0) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 1인 경우
            else if(map[x][y] == 1) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
            }
            // 물건 2인 경우
            else if(map[x][y] == 2) {
                if(!visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                }
                queue.add(new int[] {x, y});
            }
            // 물건 3인 경우 바람이 아래쪽으로 이동
            else if(map[x][y] == 3) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                down(x, y);
            }
            // 물건 4인 경우 바람이 위쪽으로 이동
            else if(map[x][y] == 4) {
                if(!visited[x][y]) {
                    count++;
                    visited[x][y] = true;
                }
                top(x, y);
            }
        }
    }
}