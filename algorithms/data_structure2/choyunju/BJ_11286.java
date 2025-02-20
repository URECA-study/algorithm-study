import java.util.*;
import java.io.*;

class Num implements Comparable<Num> {
    int num;  // 실제값
    int abs;  // 절댓값

    public Num(int num, int abs) {
        this.num = num;
        this.abs = abs;
    }

    // 절댓값이 작은 순서대로
    // 절댓값이 작은 값이 여러 개인 경우, 기존의 가장 작은 값 순서대로
    @Override
    public int compareTo(Num o) {
        if(this.abs == o.abs) {
            return this.num - o.num;
        } else {
            return this.abs - o.abs;
        }
    }
}

public class BJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Num> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(reader.readLine());
            // x가 0이라면 값 출력
            if(x == 0) {
                if(queue.isEmpty()) {
                    builder.append(0).append("\n");
                } else {
                    builder.append(queue.poll().num).append("\n");
                }
            } else {  // x가 0이 아니라면 값 저장
                queue.add(new Num(x, Math.abs(x)));
            }
        }

        System.out.println(builder);
    }
}