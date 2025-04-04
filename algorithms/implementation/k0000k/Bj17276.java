package implementation.k0000k;

import java.io.*;
import java.util.*;

public class Bj17276 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] nums;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nums = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    nums[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 시계방향으로 몇 번 회전해야 하는지 계산
            int rotateCount;
            if (d >= 0) {
                rotateCount = d / 45;
            }
            else {
                rotateCount = 8 - ((-1 * d) / 45);
            }

            for (int j = 0; j < rotateCount; j++) {
                int[] buffer = new int[n];
                majorToCenter(buffer);
                centerToSub(buffer);
                subToCenter(buffer);
                centerToMajor(buffer);
            }
            printArr();
        }
    }

    private static void majorToCenter(int[] buffer) {
        // 버퍼에 가운데 열을 저장하며, 주 대각선을 가운데 열로 옮긴다.
        int idx = 0;
        int center = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            buffer[i] = nums[i][center];
            nums[i][center] = nums[i][idx++];
        }
    }

    private static void centerToSub(int[] buffer) {
        // 버퍼(가운데 열)을 부 대각선으로 옮기면서, 버퍼에 부 대각선을 저장한다.
        int idx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i][idx];
            nums[i][idx] = buffer[i];
            buffer[i] = temp;
            idx--;
        }
    }

    private static void subToCenter(int[] buffer) {
        // 버퍼(부 대각선)을 가운데 행으로 옮기면서, 버퍼에 가운데 행을 저장한다.
        int idx = nums.length - 1;
        int center = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[center][idx];
            nums[center][idx] = buffer[i];
            buffer[i] = temp;
            idx--;
        }
    }

    private static void centerToMajor(int[] buffer) {
        // 버퍼(가운데 행)을 주 대각선으로 옮긴다.
        int idx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i][i] = buffer[idx--];
        }
    }

    private static void printArr() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
