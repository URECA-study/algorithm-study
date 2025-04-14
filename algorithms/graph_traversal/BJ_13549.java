import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] times;
    static int N, K;
    static int time = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        visited = new boolean[100001];
        times = new int[100001];
        Arrays.fill(times, Integer.MAX_VALUE);

        if(N==K) {
            System.out.println(0);
        } else {
            Node node = new Node(N, 0);
            BFS(node);
            System.out.println(times[K]);
        }
    }

    public static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.x] = true;
            //순간이동하는 경우 시간이 0초가 걸리므로 우선순위가 제일 첫 번째이다.
            if(2*now.x <= 100000 && !visited[2*now.x]) {
                times[2*now.x] = Math.min(times[2*now.x], now.time);
                queue.add(new Node(2*now.x, now.time));
            }
            if(now.x+1 <= 100000 && !visited[now.x+1]) {
                times[now.x+1] = Math.min(times[now.x+1], now.time+1);
                queue.add(new Node(now.x+1, now.time+1));
            }
            if(0 <= now.x-1 && !visited[now.x-1]) {
                times[now.x-1] = Math.min(times[now.x-1], now.time+1);
                queue.add(new Node(now.x-1, now.time+1));
            }
        }
    }
}

class Node {
    int x;
    int time;

    public Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}