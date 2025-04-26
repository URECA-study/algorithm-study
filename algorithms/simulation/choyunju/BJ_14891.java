import java.io.*;
import java.util.*;

class BJ_14891 {
    static int[][] wheel;
    static int K;
    static int[] turnDir;  //톱니바퀴 별 회전 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        wheel = new int[4][8];

        for(int i=0; i<4; i++) {
            String[] s = reader.readLine().split("");
            for(int j=0; j<s.length; j++) {
                wheel[i][j] = Integer.parseInt(s[j]);
            }
        }

        K = Integer.parseInt(reader.readLine());
        while(K-->0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int wheelNum = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());

            turnDir = new int[4];
            turnDir[wheelNum-1] = d;

            checkDir(wheelNum-1);
            rotateWheel();

        }
        int result = 0;
        for(int i=0; i<4; i++) {
            if(wheel[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    public static void checkDir(int num) {
        //현재 톱니의 왼쪽 톱니바퀴 방향 확인
        for(int i=num-1; i>=0; i--) {
            //극이 다른 경우 반대 반향으로 회전
            if(wheel[i][2] != wheel[i+1][6]) {
                turnDir[i] = -1 * turnDir[i+1];
            }
            //극이 같은 경우 회전 종료
            else break;
        }

        //현재 톱니의 오른쪽 톱니바퀴 방향 확인
        for(int i=num+1; i<4; i++) {
            if(wheel[i][6] != wheel[i-1][2]) {
                turnDir[i] = -1 * turnDir[i-1];
            }
            else break;
        }


    }

    public static void rotateWheel() {
        for(int i=0; i<4; i++) {
            // 시계방향인 경우
            if(turnDir[i] == 1) {
                int temp = wheel[i][7];
                for(int j=7; j>0; j--) {
                    wheel[i][j] = wheel[i][j-1];
                }
                wheel[i][0] = temp;
            }
            // 반시계방향인 경우
            else if(turnDir[i] == -1){
                int temp = wheel[i][0];
                for(int j=0; j<7; j++) {
                    wheel[i][j] = wheel[i][j+1];
                }
                wheel[i][7] = temp;
            }
        }
    }
}