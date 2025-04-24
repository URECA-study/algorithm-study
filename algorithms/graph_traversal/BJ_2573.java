import java.io.*;
import java.util.*;

class Node {
    int x, y, height;

    public Node(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

class BJ_2573 {
    static int N, M, n;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] ice;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        ice = new int[N][M];
        for(int i=0; i<N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());

            }
        }
        int result = 0;
        while(true) {
            visited = new boolean[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] != 0 && !visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }
            n=1;
            visited = new boolean[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] != 0 && !visited[i][j]) {
                        findMass(i, j);
                        n++;
                    }
                }
            }
            result++;
            // 덩어리로 나눠진 경우
            if(n>2) {
                break;
            }
            // 녹을 떄까지 나눠지지 않은 경우
            if(n == 1) {
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(result);
    }

    public static void findMass(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, arr[i][j]));
        visited[i][j] = true;
        ice[i][j] = n;
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int d=0; d<4; d++) {
                int x = now.x + dx[d];
                int y = now.y + dy[d];

                // 범위를 벗어나는 경우
                if(x<0 || x>=N || y<0 || y>=M) {
                    continue;
                }

                if(arr[x][y] != 0 && !visited[x][y]) {
                    ice[x][y] = n;
                    visited[x][y] = true;
                    queue.add(new Node(x, y, arr[x][y]));
                }
            }
        }
    }

    public static void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, arr[i][j]));
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int count=0;
            for(int d=0; d<4; d++) {
                int x = now.x + dx[d];
                int y = now.y + dy[d];

                // 범위를 벗어나는 경우
                if(x<0 || x>=N || y<0 || y>=M) {
                    continue;
                }

                // 상하좌우 중 바다인 경우
                if(arr[x][y] == 0 && !visited[x][y]) {
                    count++;
                }
                // 상하좌우 중 빙산인 경우
                else {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        ice[x][y] = n;
                        queue.add(new Node(x, y, arr[x][y]));
                    }
                }
            }
            arr[now.x][now.y] -= count;

            if(arr[now.x][now.y] <= 0) {
                arr[now.x][now.y] = 0;
                ice[now.x][now.y] = 0;

            }
        }
    }
}