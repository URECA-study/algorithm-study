package implementation.moomin;

import java.io.*;
import java.util.*;

public class S17276 {
    static int T, N, D;
    static int[][] arr1;
    static int[][] arr2;

    public static void main(String[] args) throws IOException {

        // T 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            // 배열 입력받기
            arr1 = new int[N][N];
            arr2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr1[i][j] = Integer.parseInt(st.nextToken());
                    arr2[i][j] = arr1[i][j];
                }
            }
            // 얼만큼 돌려볼까
            int rotation = Math.abs(D) / 45;

            // 회전
            if (D >= 0) {
                if (rotation <= 4) {
                    right(rotation);
                    continue;
                }
                left(8-rotation);
                continue;
            }

            if (rotation > 4) {
                right(8-rotation);
                continue;
            }
            left(rotation);
        }
    }

    // 배열 출력
    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 시계방향
    public static void right(int r) {
        for(int k = 0; k<r; k++) {
            for (int i = 1; i <= (N / 2); i++) {
                arr1[N / 2 - i][N / 2] = arr2[N / 2 - i][N / 2 - i];
                arr1[N / 2 - i][N / 2 + i] = arr2[N / 2 - i][N / 2];
                arr1[N / 2][N / 2 + i] = arr2[N / 2 - i][N / 2 + i];
                arr1[N / 2 + i][N / 2 + i] = arr2[N / 2][N / 2 + i];
                arr1[N / 2 + i][N / 2] = arr2[N / 2 + i][N / 2 + i];
                arr1[N / 2 + i][N / 2 - i] = arr2[N / 2 + i][N / 2];
                arr1[N / 2][N / 2 - i] = arr2[N / 2 + i][N / 2 - i];
                arr1[N / 2 - i][N / 2 - i] = arr2[N / 2][N / 2 - i];
            }

            // 깊은 복사
            for(int i = 0; i < arr1.length; i++) {
                arr2[i] = arr1[i].clone();
            }
        }
        print();
    }

    // 반시계방향
    public static void left(int r) {
        for (int k = 0; k < r; k++) {
            for (int i = 1; i <= N / 2; i++) {
                arr1[N / 2 - i][N / 2 - i] = arr2[N / 2 - i][N / 2];
                arr1[N / 2 - i][N / 2] = arr2[N / 2 - i][N / 2 + i];
                arr1[N / 2 - i][N / 2 + i] = arr2[N / 2][N / 2 + i];
                arr1[N / 2][N / 2 + i] = arr2[N / 2 + i][N / 2 + i];
                arr1[N / 2 + i][N / 2 + i] = arr2[N / 2 + i][N / 2];
                arr1[N / 2 + i][N / 2] = arr2[N / 2 + i][N / 2 - i];
                arr1[N / 2 + i][N / 2 - i] = arr2[N / 2][N / 2 - i];
                arr1[N / 2][N / 2 - i] = arr2[N / 2 - i][N / 2 - i];
            }
            // 깊은 복사
            for (int i = 0; i < arr1.length; i++) {
                arr2[i] = arr1[i].clone();
            }
        }
        print();
    }
}
