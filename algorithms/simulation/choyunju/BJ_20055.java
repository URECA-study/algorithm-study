import java.io.*;
import java.util.*;

class Main {
    static int[] belt;
    static boolean[] robots;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        belt = new int[2*N];
        robots = new boolean[N];
        token = new StringTokenizer(reader.readLine());
        for(int i=0; i<2*N; i++) {
            belt[i] = Integer.parseInt(token.nextToken());
        }

        moveRobots();
    }

    public static void moveRobots() {
        int cnt = 0;
        int result=0;
        while(result < K) {
            result = 0;
            cnt++;

            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            int temp = belt[2*N-1];
            for(int i=(2*N-1); i>0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = temp;
            for(int i=N-2; i>=0; i--) {
                // 로봇 이동
                if(robots[i]) {
                    robots[i] = false;
                    robots[i+1] = true;
                    if(i+1 == N-1) {
                        robots[i+1] = false;
                    }
                }
            }

            //2. 로봇을 한 칸 이동
            for(int i=N-2; i>=0; i--) {
                //로봇이 존재하고 다음 칸의 내구도가 1이상이며, 로봇이 없는 경우 => 이동 가능
                if(robots[i] && belt[i+1] >= 1 && !robots[i+1]) {
                    robots[i] = false;
                    //다음 칸이 내리는 곳이 아닌 경우 다음 칸은 로봇이 true 상태
                    if(i+1 != N-1) {
                        robots[i+1] = true;
                    }
                    belt[i+1] -= 1;
                }
            }

            //3. 올리는 칸의 내구도가 0이 아닌 경우 로봇을 올림
            if(belt[0] > 0) {
                robots[0] = true;
                belt[0] -= 1;
            }

            for(int i=0; i<2*N; i++) {
                if(belt[i] <= 0) {
                    result++;
                }
            }
        }
        System.out.println(cnt);
    }
}