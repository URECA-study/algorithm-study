import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    //0일 경우 벽을 안부숴버린 상태 / 1일 경우 벽을 부숴버린 상태
    int crash;

    public Node(int x, int y, int crash) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }
}

public class BJ_2206 {
    static int[][] arr;
    static int[][] distance;
    static int N, M;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        distance = new int[N][M];

        // x좌표, y좌표, 0-벽을 안부순 경우/1-벽을 부순 경우
        visited = new boolean[N][M][2];
        for(int i=0; i<N; i++) {
            String[] s = reader.readLine().split("");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 시작 지점과 도착 지점이 같은 경우 바로 종료
        if(N-1==0 && M-1==0) {
            System.out.println(1);
            System.exit(0);
        }

        BFS(new Node(0, 0, 0));

    }

    public static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int d=0; d<4; d++) {
                int x = now.x + dx[d];
                int y = now.y + dy[d];

                if(x>=0 && x<N && y>=0 && y<M) {
                    // 다음 칸에 벽이 있는 경우
                    if(arr[x][y] == 1) {
                        // 현재까지 벽을 부수지 않았다면
                        if(now.crash==0) {
                            visited[x][y][1] = true;
                            distance[x][y] = distance[now.x][now.y] + 1;
                            // crash를 1로 변경 => 벽을 부순 상태로 큐 삽입
                            queue.add(new Node(x, y, 1));
                        }
                    }
                    // 다음 칸에 벽이 없는 경우
                    else {
                        if(!visited[x][y][now.crash]) {
                            visited[x][y][now.crash] = true;
                            distance[x][y] = distance[now.x][now.y]+1;
                            queue.add(new Node(x, y, now.crash));
                        }
                    }
                    // 도착한 경우 종료
                    if(x==N-1 && y==M-1) {
                        System.out.println(distance[x][y]+1);
                        System.exit(0);
                    }
                }
            }
        }
        //도달을 못한 경우 -1 출력
        System.out.println(-1);
    }
}