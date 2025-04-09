package implementation.moomin;

import java.io.*;
import java.util.*;

public class G16926 {
    static int N, M, R;
    static int[][] arr1;
    static int[][] arr2;

    public static void main(String[] args) throws IOException {

        // N, M, R 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력받기
        arr1 = new int[N][M];
        arr2 = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
                arr2[i][j] = arr1[i][j];
            }
        }

        for(int i = 0; i<R; i++){
            rotate();
        }

        // 출력
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 반시계 방향 회전
    static void rotate() {
        // 왼
        for(int i = 0; i<Math.min(N, M)/2; i++){
            for(int j = i+1; j<N-i; j++) {
                arr1[j][i] = arr2[j-1][i];
                // 1 0 = 0 0
                // 2 0 = 1 0
                // 3 0 = 2 0
                // 2 1 = 1 1
            }
        }

        // 아래
        for(int i = 0; i<Math.min(N, M)/2; i++){
            for(int j = i+1; j<M-i; j++) {
                arr1[N-i-1][j] = arr2[N-i-1][j-1];
                // 4 3 = 4 2
                // 4 2 = 4 1
                // 4 1 = 4 0
                // 3 2 = 3 1
            }
        }

        // 오
        for(int i = 0; i<Math.min(N, M)/2; i++) {
            for (int j = i; j<N-i-1; j++) {
                arr1[j][M-i-1] = arr2[j+1][M-i-1];
                // 2 3 = 3 3
                // 1 3 = 2 3
                // 0 3 = 1 3
                // 1 2 = 2 2
            }
        }

        // 위
        for(int i = 0; i<Math.min(N, M)/2; i++){
            for(int j = i ; j<M-i-1; j++) {
                arr1[i][j] = arr2[i][j+1];
                // 0 0 = 0 1
                // 0 1 = 0 2
                // 0 2 = 0 3
                // 1 1 = 1 2
            }
        }

        // 배열 복사
        for(int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i].clone();
        }
    }
}
