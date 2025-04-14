import java.io.*;
import java.util.*;

class BJ_2615 {
    static int cnt;  //바둑알의 개수

    //오른쪽, 아래, 오른쪽 위, 오른쪽 아래 방향
    static int[] dx = {0, 1, -1, 1};
    static int[] dy = {1, 0, 1, 1};
    static boolean[][] visited;
    static int[][] baduk;
    static boolean win;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //바둑판 채우기
        baduk = new int[20][20];
        for(int i=1; i<20; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            for(int j=1; j<20; j++) {
                baduk[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        visited = new boolean[20][20];

        for(int x=1; x<20; x++) {
            for(int y=1; y<20; y++) {
                //바둑알이 놓여져 있다면
                if(baduk[x][y] != 0) {
                    for(int d=0; d<4; d++) {
                        win = false;
                        cnt = 1;
                        findWinner(x, y, baduk[x][y], cnt, d);
                        if(win) {
                            //이전 바둑알이 존재할 경우 이긴 것이 아니다.
                            int lastX = x - dx[d];
                            int lastY = y - dy[d];
                            if(baduk[lastX][lastY] != baduk[x][y]) {
                                System.out.println(baduk[x][y]);
                                System.out.println(x + " " + y);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static void findWinner(int x, int y, int color, int cnt, int d) {

        int nextX = x + dx[d];
        int nextY = y + dy[d];
        //바둑알이 5개만 연속으로 존재하는지 확인
        if(cnt == 5) {
            //범위를 벗어날 경우 이김
            if(nextX<1 || nextX>=20 || nextY<1 || nextY>=20) {
                win = true;
                return;
            }
            //바둑알이 6개가 되는 경우 이긴 것이 아님
            if(baduk[nextX][nextY] == color) {
                return;
            } else {  //바둑알이 오직 5개인 경우만 이김
                win = true;
                return;
            }
        }

        if(1<=nextX && nextX<20 && 1<=nextY && nextY<20) {
            //같은 바둑알이 아닐 경우 return
            if(baduk[nextX][nextY] != color) {
                return;
            }
            findWinner(nextX, nextY, baduk[nextX][nextY], cnt+1, d);
        }
    }
}