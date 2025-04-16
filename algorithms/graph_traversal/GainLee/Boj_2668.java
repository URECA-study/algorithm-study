package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

public class Boj_2668 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; static int cnt = 0;
    static int[] map;
    static boolean[] visited ;
    static ArrayList<Integer> res_arr = new ArrayList<>();

    static void dfs(int start, int target) {
        if (!visited[map[start]]) {
            visited[map[start]] = true;
            dfs(map[start], target);
            visited[map[start]] = false;
        }
        if (map[start] == target) res_arr.add(target);

    } // dfs

    public static void main(String[] args) throws IOException {
        // 입력
        n = Integer.parseInt(br.readLine());
        map = new int[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        } // for

        visited = new boolean[n+1];

        // dfs 로 사이클 검사
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(res_arr);
        System.out.println(res_arr.size());
        for (int i = 0; i < res_arr.size(); i++) {
            System.out.println(res_arr.get(i));
        }
    } //main
}
