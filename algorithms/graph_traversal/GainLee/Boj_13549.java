package graph_traversal.GainLee;

import java.io.*;
import java.util.*;

class State {
    public int position;
    public int time;

    public State (int position, int time) {
        this.position = position;
        this.time = time;
    }
}

public class Boj_13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int MAX_POSITION = 100_000;
    static final int INF = 100_000;
    static int n; static int k; static int sec = 0;
    static int[] visited = new int[MAX_POSITION+1];
    static Queue<State> queue = new LinkedList<>();

    static void bfs(){
        Arrays.fill(visited, INF);
        visited[n] = 0;
        queue.add(new State(n, 0));

        while (!queue.isEmpty()) {
            State current = queue.remove();

            // np 는 new_positon의 약자
            // np1 : n-1
            // np2 : n+1
            // np3 : n*2
            int np1 = current.position - 1;
            if (isValid(np1) && visited[np1] > current.time + 1) {
                visited[np1] = current.time+1;
                queue.add(new State(np1, visited[np1]));
            }

            int np2 = current.position + 1;
            if (isValid(np2) && visited[np2] > current.time + 1) {
                visited[np2] = current.time+1;
                queue.add(new State(np2, visited[np2]));
            }

            int np3 = current.position * 2;
            if (isValid(np3) && visited[np3] > current.time) {
                visited[np3] = current.time;
                queue.add(new State(np3, visited[np3]));
            }
        } // while
        sec = visited[k];
    } // bfs

    static boolean isValid (int position) {
        return 0 < position && position <= MAX_POSITION;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            sec = n - k;
        } else {
            bfs();
        }

        System.out.println(sec);
    } // main
}
