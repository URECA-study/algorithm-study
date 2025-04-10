package graph_traversal.k0000k;

import java.io.*;
import java.util.*;

public class Bj2668 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] nums;
    public static boolean[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i == nums[i]) { // 미리 answer에 담아놓기
                answer.add(i);
            }
        }

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                ArrayList<Integer> result = dfs(i, new ArrayList<>(), new boolean[n + 1]);
                if (!result.isEmpty()) { // 유효한 사이클이 있다면
                    for (Integer num : result) { // answer과 visited에 반영
                        visited[num] = true;
                        answer.add(num);
                    }
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer num : answer) {
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> dfs(int i, ArrayList<Integer> result, boolean[] currentVisited) {
        if (i == nums[i]) { // 탐색 도중 이 경우가 발생하면 절대 정답에 포함 될 수 없음.
            return new ArrayList<>();
        }
        if (!currentVisited[i] && result.contains(nums[i])) { // 현재 노드에 처음 방문하지만 이미 result에 숫자가 있는경우
            return new ArrayList<>();
        }
        if (currentVisited[i]) { // 사이클 완성
            return result;
        }
        currentVisited[i] = true;
        result.add(nums[i]);
        return dfs(nums[i], result, currentVisited);
    }

}
