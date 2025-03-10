import java.io.*;
import java.util.*;

class Box implements Comparable<Box> {
    int start;
    int end;
    int num;

    public Box(int start, int end, int num) {
        this.start = start;
        this.end = end;
        this.num = num;
    }

    @Override
    public int compareTo(Box o) {
        if(this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

class BJ_8980 {
    static int C;
    static int[] truck;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        truck = new int[N+1];  // 담을 수 있는 트럭 용량을 저장하기 위한 배열

        int M = Integer.parseInt(reader.readLine());
        PriorityQueue<Box> queue = new PriorityQueue<>();

        for(int i=0; i<M; i++) {
            token = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int num = Integer.parseInt(token.nextToken());
            queue.add(new Box(start, end, num));
        }

        //상자를 아무것도 안 담은 경우엔 C만큼의 용량을 담을 수 있음
        Arrays.fill(truck, C);
        int total = 0;
        while(!queue.isEmpty()) {
            Box box = queue.poll();
            int start = box.start;
            int end = box.end;
            int num = box.num;
            int capacity = findCapacity(start, end);

            //담울 수 있는 용량보다 박스의 수가 적으면 박스 수만큼만 트럭에 담는다.
            if(num < capacity) {
                capacity = num;
            }

            for(int i=start; i<end; i++) {
                truck[i] = truck[i] - capacity;
            }
            total += capacity;
        }

        System.out.println(total);
    }

    //출발에서 도착까지 중 담을 수 있는 용량이 제일 적은 수만큼만 트럭에 담을 수 있다.
    public static int findCapacity(int start, int end) {
        int capacity = truck[start];
        for(int i=start; i<end; i++) {
            capacity = Math.min(capacity, truck[i]);
        }
        return capacity;
    }
}