import java.io.*;
import java.util.*;

public class BJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(reader.readLine());
            // x가 자연수인 경우
            if(x == 0) {
                if(queue.isEmpty()) {
                    builder.append(0).append("\n");
                } else {
                    builder.append(queue.poll()).append("\n");
                }
            } else {  // 자연수가 아닌 경우
                queue.add(x);
            }
        }
        System.out.println(builder);
    }
}