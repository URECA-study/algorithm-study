import java.io.*;
import java.util.*;

class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 개수
        int N = Integer.parseInt(reader.readLine());

        while(N-->0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int count = Integer.parseInt(token.nextToken());  //문서의 개수
            int index = Integer.parseInt(token.nextToken());  //찾고자 하는 문서의 위치 인덱스

            Queue<Doc> queue = new LinkedList<>();
            token = new StringTokenizer(reader.readLine());
            for(int i=0; i<count; i++) {
                queue.add(new Doc(i, Integer.parseInt(token.nextToken())));
            }

            int n=1;
            boolean isDelete = false;
            if(count == 1) {
                System.out.println(1);
            } else {
                while(!queue.isEmpty()) {
                    Doc now = queue.poll();
                    for(Doc next : queue) {
                        if(now.priority < next.priority) {
                            queue.add(now);
                            isDelete = false;
                            break;
                        } else {
                            isDelete = true;
                        }
                    }
                    if(isDelete) {
                        if(now.num == index) {
                            System.out.println(n);
                            break;
                        } else {
                            n++;
                        }
                    }
                }
            }

        }
    }
}

class Doc {
    int num;
    int priority;

    public Doc(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
}