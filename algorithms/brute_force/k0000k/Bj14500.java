package brute_force.k0000k;

import java.io.*;
import java.util.*;

public class Bj14500 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] nums;
    public static int answer = 0;
    public static int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<int[]> selected = new ArrayList<>();
                selected.add(new int[] {i, j});
                findMax(selected, nums[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static void findMax(ArrayList<int[]> selected, int sum) {
        if (selected.size() == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        int length = selected.size();
        for (int i = 0; i < length; i++) {
            int[] node = selected.get(i);
            for (int[] dir : directions) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (isRange(x, y) && isNotIn(selected, x, y)) {
                    selected.add(new int[]{x, y});
                    findMax(selected, sum + nums[x][y]);
                    selected.remove(selected.size() - 1);
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return (x >= 0) && (x < nums.length) && (y >= 0) && (y < nums[0].length);
    }

    private static boolean isNotIn(ArrayList<int[]> selected, int x, int y) {
        for (int[] node : selected) {
            if (node[0] == x && node[1] == y) {
                return false;
            }
        }
        return true;
    }

}
