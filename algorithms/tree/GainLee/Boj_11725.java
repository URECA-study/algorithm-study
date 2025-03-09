import java.io.*;
import java.util.*;

public class Boj_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static int n;

    public static void main (String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        parents = new int[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        } // for
        
        dfs(1, 0);

        // 출력
        for (int i = 2; i < n+1; i++) {
            System.out.println(parents[i]);
        }

    br.close();
    } // main

    static void dfs(int current, int p){
        parents[current] = p;
        for (int child : tree[current]) {
            if (child != p) {
                dfs(child, current);
            }
        }
    }; // dfs
    
}
