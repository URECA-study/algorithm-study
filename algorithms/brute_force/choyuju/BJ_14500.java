import java.io.*;
import java.util.*;

class BJ_14500 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                DFS(i, j, arr[i][j], 0);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    public static void DFS(int i, int j, int sum, int depth) {
        //4개의 블록이 되면 max와 지금까지의 sum을 비교
        if(depth==3) {
            max = Math.max(max, sum);
            return;
        }

        for(int d=0; d<4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            //범위를 벗어나면 다시 반복
            if(x<0 || x>=N || y<0 || y>=M) {
                continue;
            }
            if(!visited[x][y]) {
                // 'ㅜ'자 모양을 계산하기 위해 2번째블록에 3번쨰 블록까지의 합을 더한 후,
                // i, j는 그대로 설정한 후 depth만 1을 더한 재귀함수를 호출한다.
                if(depth==1) {
                    visited[x][y] = true;
                    DFS(i, j, sum + arr[x][y], depth+1);
                    visited[x][y] = false;
                }
                visited[x][y] = true;
                DFS(x, y, sum+arr[x][y], depth+1);
                visited[x][y] = false;
            }
        }
    }
}