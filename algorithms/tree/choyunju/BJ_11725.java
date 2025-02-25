import java.io.*;
import java.util.*;

class BJ_11725 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[N+1];  // 각 노드의 부모를 저장

        for(int i=0; i<N-1; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        DFS(1);

        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for(int next : tree[node]) {
            if(!visited[next]) {
                parent[next] = node;
                DFS(next);
            }
        }
    }
}