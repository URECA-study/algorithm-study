package brute_force.GainLee;

import java.io.*;
import java.util.*;

public class Boj_15661 {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int min = 100_0000;

    static void dfs(int index) {
        if (index == n) {
            List<Integer> team_a = new ArrayList<>();
            List<Integer> team_b = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (visited[i]) team_a.add(i);
                else team_b.add(i);
            }

            if (team_a.isEmpty() || team_b.isEmpty()) return;

            int score_a = calc(team_a);
            int score_b = calc(team_b);
            min = Math.min(min, Math.abs(score_a - score_b));
            return;
        }

        visited[index] = true;
        dfs(index + 1);
        visited[index] = false;
        dfs(index + 1);
    }

    static int calc (List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i+1; j < team.size(); j++) {
                int a = team.get(i);
                int b = team.get(j);
                sum += arr[a][b] + arr[b][a];
            }
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr  = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);

    } // main
}
