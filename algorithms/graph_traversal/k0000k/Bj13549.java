package graph_traversal.k0000k;

import java.io.*;
import java.util.*;

class Node {
    int time;
    int location;

    public Node(int time, int location) {
        this.time = time;
        this.location = location;
    }
}

public class Bj13549 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Node> queue = new ArrayDeque<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (end < start) { // 도착점이 시작점보다 작은 숫자면 바로 종료
            System.out.println(start - end);
            return;
        }

        visited = new boolean[100001];
        queue.addLast(new Node(0, start));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            int time = node.time;
            int location = node.location;
            if (location == end) { // 종료조건
                System.out.println(time);
                return;
            }

            // x에서 x + 1로 1칸 커지는 것 보다, 그보다 더 작은 값에서 2 곱해지는 것이 우선순위가 높다.
            // 따라서, -1이 1보다 먼저 큐에 들어가야 한다.
            int[] locations = new int[] {2 * location, location - 1, location + 1};
            int[] times = new int[] {time, time + 1, time + 1};
            for (int i = 0; i < locations.length; i++) {
                if (isRange(locations[i]) && !visited[locations[i]]) {
                    // 0-1 BFS 수행
                    if (i == 0) { // 간선의 가중치가 0일때는 Queue 앞에 넣기
                        queue.addFirst(new Node(times[i], locations[i]));
                    }
                    else { // 간선의 가중치가 1일때는 Queue 뒤에 넣기
                        queue.addLast(new Node(times[i], locations[i]));
                    }
                    visited[locations[i]] = true; // 방문처리
                }
            }
        }
    }

    private static boolean isRange(int idx) {
        return (idx >= 0) && (idx < visited.length);
    }
}
