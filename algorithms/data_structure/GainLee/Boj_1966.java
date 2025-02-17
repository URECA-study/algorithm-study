import java.io.*;
import java.util.*;

public class Boj_1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Docs {
        int idx; // 문서 위치
        int important; // 문서 중요도

        public Docs(int idx, int important) {
            this.idx = idx;
            this.important = important;
        }
    } // Docs class

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Docs> docs = new LinkedList<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            // 문서 중요도 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int important = Integer.parseInt(st.nextToken());
                docs.add(new Docs(j, important));
                queue.add(important); // 중요도 저장
            } //for

            int printCount = 0;

            while (!docs.isEmpty()) {
                Docs current = docs.poll();
                if(current.important == queue.peek()) {
                    // 현재 중요도와 중요도의 최대값과 일치한다면
                    queue.poll();
                    printCount++;

                    if (current.idx == m) {
                        System.out.println(printCount);
                        break;
                    } // if
                } else {
                    docs.add(current);
                } // if else
            } // while

        } // for

        br.close();
    } // main
}