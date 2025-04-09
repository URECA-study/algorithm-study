package implementation.moomin;

import java.io.*;
import java.util.*;

public class G14719 {

    static int H, W;
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws IOException {

        // H, W 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 블록 입력받기
        arr = new int[H][W+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=W; i++){
            int h = Integer.parseInt(st.nextToken());
            for(int j = 0; j<h; j++){
                arr[H-j-1][i] = 1;
            }
        }

        // 빗물 탐색
        for(int i = H-1; i>=0; i--){
            int start = 0;
            int end = 1;
            while(end <= W){

                // 처음 1이라면 start-end 설정
                if(arr[i][end] == 1 && start == 0){
                    start = end;
                    end++;
                    continue;
                }

                // 처음 1이 아니라면 고인 빗물 구하기
                if(arr[i][end] == 1 && start != 0){
                    ans += end - start - 1;
                    start = end;
                    end++;
                    continue;
                }
                end++;
            }
        }
        System.out.println(ans);
    }
}
