import java.io.*;
import java.util.*;

class Country {
    int i, j;

    public Country(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class BJ_16234 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int N, L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            token = new StringTokenizer(reader.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int days = 0;

        while(true) {
            int count = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        int n =BFS(i, j);
                        count = Math.max(count, n);
                    }
                }
            }
            if(count == 0) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    static int BFS(int i, int j) {
        int count = 0;
        int sum = 0;
        Queue<Country> queue = new LinkedList<>();
        queue.add(new Country(i, j));
        ArrayList<Country> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Country now = queue.poll();

            for(int d=0; d<4; d++) {
                int x = now.i + dx[d];
                int y = now.j + dy[d];

                if(x>=0 && x<N && y>=0 && y<N) {
                    int diff = Math.abs(arr[x][y] - arr[now.i][now.j]);

                    if(!visited[x][y] && diff >= L && diff <= R) {
                        visited[x][y] = true;
                        list.add(new Country(x, y));
                        sum += arr[x][y];
                        count++;
                        queue.add(new Country(x, y));
                    }
                }
            }
        }

        for(Country c : list) {
            arr[c.i][c.j] = sum/count;
        }
        return count;
    }
}