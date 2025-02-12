package data_structure.k0000k;

import java.util.*;
import java.io.*;

public class Bj1874 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static ArrayList<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        boolean isImpossible = false;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.add(queue.pollFirst());
                answers.add("+");
            }
            while (num > stack.peekLast()) {
                stack.add(queue.pollFirst());
                answers.add("+");
            }
            if (num == stack.peekLast()) {
                stack.pollLast();
                answers.add("-");
            }
            else if (num < stack.peekLast()) {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            System.out.println("NO");
        }
        else {
            for (String str : answers) {
                System.out.println(str);
            }
        }

    }
}
