import java.io.*;
import java.util.*;

class BJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        Deque<Integer> list = new ArrayDeque<>();
        //1~N번의 풍선을 차례로 저장

        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        //각 풍선마다 가지고 있는 종이의 값 저장
        int[] num = new int[N+1];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for(int i=1; i<=N; i++) {
            int n = Integer.parseInt(token.nextToken());
            num[i] = n;
        }

        //현재 1번 풍선 제거
        int now = list.pollFirst();
        while(!list.isEmpty()) {
            builder.append(now + " ");

            int nowNum = num[now];
            if(nowNum > 0) {  // 양수라면 오른쪽 이동
                for(int i=0; i<nowNum-1; i++) {
                    list.add(list.pollFirst());
                }
                now = list.pollFirst();
            } else {

                for(int i=0; i<(-1)*nowNum-1; i++) {
                    list.addFirst(list.pollLast());
                }
                now = list.pollLast();
            }
        }
        //마지막 값 저장
        builder.append(now);
        System.out.println(builder);

    }
}