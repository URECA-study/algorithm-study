import java.io.*;
import java.util.*;

class BJ_15661 {
    static int N, min;
    static int[][] S;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        S = new int[N][N];
        min = Integer.MAX_VALUE;
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            for(int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int node) {
        // 부분집합이 완성되면 link와 start의 차이를 구한다.
        if(node == N) {
            findDiff();
            return;
        }
        visited[node] = true;
        dfs(node+1);
        visited[node] = false;
        dfs(node+1);
    }

    public static void findDiff() {
        int link = 0;  // visited가 true인 경우
        int start = 0; // visited가 false인 경우
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] != visited[j]) {
                    continue;
                }
                if(visited[i] && visited[j]) {
                    link += S[i][j] + S[j][i];
                } else {
                    start += S[i][j] + S[j][i];
                }
            }
        }
        int diff = Math.abs(link - start);
        if(diff<min) {
            min = diff;
        }
    }
}