package brute_force.moomin;

import java.io.*;
import java.util.*;

public class G15661 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int count;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 팀 입력받기
        arr = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 몇팀으로 쪼갤까?
        for(int i = 2; i<= N/2; i++) {
            count = i;
            visited = new boolean[N + 1];
            teamBuilding(1, count);
        }

        System.out.println(ans);

    }
    public static void teamBuilding(int s, int c){
        if(c == 0){
            // 팀빌딩 완료, 두 팀의 능력 차이는?
            diff();
            if(ans == 0){
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for(int i = s; i<=N; i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            teamBuilding(i+1, c-1);
            visited[i] = false;
        }
    }

    public static void diff(){
        int[] start = new int[count];
        int[] link = new int[N-count];

        int startScore = 0;
        int linkScore = 0;

        // 스타트팀과 링크팀 배정
        int s = 0;
        int l = 0;

        for(int i=1; i<=N; i++){
            if(visited[i] == true) {
                start[s++] = i-1;
                continue;
            }
            link[l++] = i-1;
        }

        // 스타트팀 능력
        for(int i = 0; i<start.length; i++){
            for(int j = i; j<start.length; j++){
                if(i == j) continue;
                startScore += arr[start[i]][start[j]] + arr[start[j]][start[i]];
            }
        }

        // 링크팀 능력
        for(int i = 0; i<link.length; i++){
            for(int j = i; j<link.length; j++){
                if(i == j) continue;
                linkScore += arr[link[i]][link[j]] + arr[link[j]][link[i]];
            }
        }
        ans = Math.min(ans, Math.abs(startScore-linkScore));
    }
}
