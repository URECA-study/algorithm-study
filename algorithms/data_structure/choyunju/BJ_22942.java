import java.io.*;
import java.util.*;

public class BJ_22942 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Circle> queue = new PriorityQueue<>();
        boolean flag = true;
        while(N --> 0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(token.nextToken());
            int r = Integer.parseInt(token.nextToken());
            queue.add(new Circle(x, r, x-r, x+r));
        }
        while(!queue.isEmpty()) {
            Circle now = queue.poll();
            for(Circle next : queue) {
                //next의 왼쪽이 now의 오른쪽보다 크면 무조건 외부에 있는 경우이므로 만나지 않는다.
                if(next.left > now.right) {
                    break;
                }

                int d = Math.abs(now.x - next.x);  // 두 원의 중심 사이의 거리
                //두 원이 내부에 있는지 확인
                if(d < Math.abs(now.r - next.r)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                break;
            }
        }
        if(!flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}

class Circle implements Comparable<Circle> {
    int x;
    int r;
    int left;
    int right;

    public Circle(int x, int r, int left, int right) {
        this.x = x;
        this.r = r;
        this.left = left;
        this.right = right;
    }

    //왼쪽의 오름차순 정렬
    @Override
    public int compareTo(Circle o) {
        return this.left - o.left;
    }
}