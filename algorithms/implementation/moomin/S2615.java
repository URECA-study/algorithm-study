package implementation.moomin;

import java.io.*;
import java.util.*;

public class S2615 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr = new int[21][21];

    public static void main(String[] args) throws IOException {

        // 오목판 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i<=19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j<=19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        for(int i = 1; i<=19; i++){
            for(int j = 1; j<=19; j++){
                if(arr[i][j] == 0) continue;

                // 오른쪽
                right(i, j);

                // 아래
                down(i, j);

                // 오른쪽 아래 대각선
                rightDownDiagonal(i, j);

                // 왼쪽 아래 대각선
                leftDownDiagonal(i, j);
            }
        }

        if(sb.length() == 0){
            System.out.println(0);
            return;
        }

        System.out.println(sb.toString().trim());
    }

    // 오른쪽
    public static void right(int y, int x) {

        // 시작점 확인
        if ((arr[y][x] == arr[y][x - 1])) return;

        for (int i = 1; i < 5; i++) {
            if (arr[y][x] != arr[y][x+i]) return;
        }

        // 연속된 돌의 갯수가 5개인지 확인
        if (arr[y][x] == arr[y][x + 5]) return;

        sb.append(arr[y][x]).append("\n").append(y).append(" ").append(x);
    }

    // 아래
    public static void down(int y, int x){

        // 시작점 확인
        if(arr[y][x] == arr[y-1][x]) return;

        for(int i = 1; i<5; i++){
            if(arr[y][x] != arr[y+i][x]) return;
        }

        // 연속된 돌의 갯수가 5개인지 확인
        if (arr[y][x] == arr[y+5][x]) return;

        sb.append(arr[y][x]).append("\n").append(y).append(" ").append(x);

    }

    // 오른쪽 아래 대각선
    public static void rightDownDiagonal(int y, int x){

        // 시작점 확인
        if(arr[y][x] == arr[y-1][x-1]) return;

        // 오른쪽 아래 대각선으로 탐색
        for(int i = 1; i<5; i++){
            if(arr[y][x] != arr[y+i][x+i]) return;
        }

        // 연속된 돌의 갯수가 5개인지 확인
        if (arr[y][x] == arr[y+5][x+5]) return;

        sb.append(arr[y][x]).append("\n").append(y).append(" ").append(x);

    }

    // 왼쪽 아래 대각선
    public static void leftDownDiagonal(int y, int x){

        // 시작점 확인
        if(arr[y][x] == arr[y-1][x+1]) return;

        // 왼쪽 아래 대각선으로 탐색
        for(int i = 1; i<5; i++){
            if(arr[y][x] != arr[y+i][x-i]) return;
        }

        // 연속된 돌의 갯수가 5개인지 확인
        if (arr[y][x] == arr[y+5][x-5]) return;

        sb.append(arr[y][x]).append("\n").append(y+4).append(" ").append(x-4);
    }
}
