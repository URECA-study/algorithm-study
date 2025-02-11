package data_structure.k0000k;

import java.io.*;
import java.util.*;

class Balloon {
    int number;
    int paper;

    public Balloon(int number, int paper) {
        this.number = number;
        this.paper = paper;
    }
}

public class Bj2346 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Balloon> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(idx++, num));
        }

        for (int i = 0; i < n; i++) {
            Balloon balloon = deque.pollFirst();
            rotateDeque(balloon);
            System.out.print(balloon.number + " ");
        }

    }

    private static void rotateDeque(Balloon balloon) {
        if (deque.isEmpty()) {
            return;
        }
        if (balloon.paper < 0) {
            int val = -1 * balloon.paper;
            for (int i = 0; i < val; i++) {
                deque.addFirst(deque.pollLast());
            }
        }
        else if (balloon.paper - 1 > 0) {
            for (int i = 0; i < balloon.paper - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
        }
    }
}