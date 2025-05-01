import java.io.*;
import java.util.*;

class BJ_20165 {
    static int[][] map;
    static int N, M, R, result;
    static boolean[][] visited;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        map = new int[N+1][M+1];
        arr = new char[N+1][M+1];
        visited = new boolean[N+1][M+1];
        result = 0;
        for(int i=1; i<=N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                arr[i][j] = 'S';
            }
        }
        for(int i=0; i<R; i++) {
            // 공격수 차례
            token = new StringTokenizer(reader.readLine());
            int FW_x = Integer.parseInt(token.nextToken());
            int FW_y = Integer.parseInt(token.nextToken());
            char d = token.nextToken().charAt(0);
            // 동쪽으로 넘어지는 경우
            if(d == 'E') {
                east(FW_x, FW_y);
            }
            // 서쪽으로 넘어지는 경우
            else if(d == 'W') {
                west(FW_x, FW_y);
            }
            // 남쪽으로 넘어지는 경우
            else if(d == 'S') {
                south(FW_x, FW_y);
            }
            // 북쪽으로 넘어는 경우
            else {
                north(FW_x, FW_y);
            }

            //수비수 차례
            token = new StringTokenizer(reader.readLine());
            int DF_x = Integer.parseInt(token.nextToken());
            int DF_y = Integer.parseInt(token.nextToken());
            arr[DF_x][DF_y] = 'S';
        }

        System.out.println(result);
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void east(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y] != 'F') {
            arr[x][y] = 'F';
            result++;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = map[now[0]][now[1]];
            for(int i=1; i<num; i++) {
                int nextX = now[0];
                int nextY = now[1] + i;
                //범위를 벗어나면 종료
                if(nextX<1 || nextX>N || nextY<1 || nextY>M) {
                    break;
                }
                if(arr[nextX][nextY]!='F') {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = 'F';
                    result++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    static void west(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y] != 'F') {
            arr[x][y] = 'F';
            result++;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = map[now[0]][now[1]];
            for(int i=1; i<num; i++) {
                int nextX = now[0];
                int nextY = now[1] - i;
                //범위를 벗어나면 종료
                if(nextX<1 || nextX>N || nextY<1 || nextY>M) {
                    break;
                }
                if(arr[nextX][nextY]!='F') {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = 'F';
                    result++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    static void south(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y] != 'F') {
            arr[x][y] = 'F';
            result++;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = map[now[0]][now[1]];
            for(int i=1; i<num; i++) {
                int nextX = now[0] + i;
                int nextY = now[1];
                //범위를 벗어나면 종료
                if(nextX<1 || nextX>N || nextY<1 || nextY>M) {
                    break;
                }
                if(arr[nextX][nextY]!='F') {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = 'F';
                    result++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }

    static void north(int x, int y) {
        visited[x][y] = true;
        if(arr[x][y] != 'F') {
            arr[x][y] = 'F';
            result++;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = map[now[0]][now[1]];
            for(int i=1; i<num; i++) {
                int nextX = now[0] - i;
                int nextY = now[1];
                //범위를 벗어나면 종료
                if(nextX<1 || nextX>N || nextY<1 || nextY>M) {
                    break;
                }
                if(arr[nextX][nextY]!='F') {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = 'F';
                    result++;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }
}