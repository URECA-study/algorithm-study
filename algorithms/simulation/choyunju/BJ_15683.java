import java.io.*;
import java.util.*;

class CCTV {
    int x, y, num, rotate;
    public CCTV(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }
}

class BJ_15683 {
    static int N, M;
    static int[][] map;
    static ArrayList<CCTV> list;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if(map[i][j]>=1 && map[i][j] <=5) {
                    list.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        DFS(0);

        System.out.println(answer);
    }

    public static void DFS(int depth) {
        if(depth == list.size()) {
            monitor();
            return;
        }

        for(int d=0; d<4; d++) {
            list.get(depth).setRotate(d);
            DFS(depth+1);
        }
    }

    static void monitor() {
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for(int i=0; i<list.size(); i++) {
            CCTV cctv = list.get(i);
            int[][] directions = getDirections(cctv.num, cctv.rotate);
            for(int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                int x = cctv.x;
                int y = cctv.y;
                while(x+dx>=0 && x+dx<N && y+dy>=0 && y+dy<M) {
                    x += dx;
                    y += dy;

                    // 벽인 경우 더이상 감시 X
                    if(temp[x][y] == 6) {
                        break;
                    }
                    if(temp[x][y] == 0) {
                        temp[x][y] = -1;
                    }
                }
            }
        }
        answer = Math.min(getNumOfBlindSpots(temp), answer);
    }

    static int[][] getDirections(int num, int rotate) {
        int[][] directions;
        if (num == 1) {
            directions = new int[][]{{0, 1}};
        } else if (num == 2) {
            directions = new int[][]{{0, 1}, {0, -1}};
        } else if (num == 3) {
            directions = new int[][]{{-1, 0}, {0, 1}};
        } else if (num == 4) {
            directions = new int[][]{{-1, 0}, {0, 1}, {0, -1}};
        } else {
            directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        }

        for(int i=0; i<rotate; i++) {
            for(int j=0; j<directions.length; j++) {
                int dx = directions[j][0];
                int dy = directions[j][1];
                //위쪽 -> 오른쪽
                if(dx==-1 && dy==0) {
                    directions[j][0] = 0;
                    directions[j][1] = 1;
                }
                //오른쪽 -> 아래쪽
                else if(dx==0 && dy==1) {
                    directions[j][0] = 1;
                    directions[j][1] = 0;
                }
                //아래쪽 -> 왼쪽
                else if(dx==1 && dy==0) {
                    directions[j][0] = 0;
                    directions[j][1] = -1;
                }
                //왼쪽 -> 위쪽
                else {
                    directions[j][0] = -1;
                    directions[j][1] = 0;
                }
            }
        }
        return directions;
    }

    static int getNumOfBlindSpots(int[][] temp) {
        int numOfBlindSpots = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(temp[i][j]==0) {
                    numOfBlindSpots++;
                }
            }
        }

        return numOfBlindSpots;
    }
}