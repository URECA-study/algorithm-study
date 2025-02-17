package data_structure.k0000k;

import java.io.*;
import java.util.*;

class Circle implements Comparable<Circle> {
    int start;
    int end;
    int r;

    public Circle(int x, int r) {
        this.r = r;
        this.start = x - r;
        this.end = x + r;
    }

    @Override
    public int compareTo(Circle o) {
        return this.start - o.start;
    }

    @Override
    public String toString() {
        return "start = " + start + " end = " + end;
    }
}
/*
1. 아예 영역이 겹치지 않는다.
2. 겹치지만 나중에 시작한 영역이 먼저 끝난다. (스택처럼)
*/
public class Bj22942 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Circle> circles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles.add(new Circle(x, r));
        }

        Collections.sort(circles);
        ArrayDeque<Circle> stack = new ArrayDeque<>();
//        System.out.println(circles);
        stack.add(circles.get(0));
        for (int i = 1; i < n; i++) {
            Circle circle = circles.get(i);
            Circle stackTop = stack.peekLast();
            if (stackTop.end < circle.start) {
                stack.add(circle);
            }
            else if (circle.end < stackTop.end) {
                stack.add(circle);
            }
            else {
//                System.out.println(i);
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
