package tree.k0000k;

import java.io.*;
import java.util.*;

public class Bj9934 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> order = new ArrayList<>();
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    public static int buildingIdx = 0;

    public static void main(String[] args) throws IOException {
        int maxLevel = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            order.add(Integer.parseInt(st.nextToken()));
        }

        init(maxLevel);
        traverse(1);

        for (int i = 1; i < levels.size(); i++) {
            ArrayList<Integer> list = levels.get(i);
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void traverse(int nodeIdx) {
        int leftIdx = nodeIdx * 2;
        int rightIdx = leftIdx + 1;

        // 왼쪽 노드
        if (leftIdx < visited.length && !visited[leftIdx]) {
            traverse(leftIdx);
        }

        // 현재 노드
        visited[nodeIdx] = true;
        calcLevel(nodeIdx);

        // 오른쪽 노드
        if (rightIdx < visited.length && !visited[rightIdx]) {
            traverse(rightIdx);
        }
    }

    private static void calcLevel(int nodeIdx) {
        int level = 1;
        int firstNodeIdx = 1;
        while (nodeIdx >= firstNodeIdx * 2) {
            firstNodeIdx *= 2;
            level += 1;
        }
        levels.get(level).add(order.get(buildingIdx++));
    }

    private static void init(int maxLevel) {
        visited = new boolean[order.size() + 1];
        for (int i = 0; i < maxLevel + 1; i++) {
            levels.add(new ArrayList<>());
        }
    }
}
