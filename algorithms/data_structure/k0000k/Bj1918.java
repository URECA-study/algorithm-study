package data_structure.k0000k;

import java.io.*;
import java.util.*;

public class Bj1918 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<String> inputQueue;
    public static ArrayDeque<String> stack;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        inputQueue = new ArrayDeque<>(Arrays.asList(input));
        stack = new ArrayDeque<>();
        while (!inputQueue.isEmpty()) {
            calculate();
        }

        if (stack.size() != 1) {
            System.out.println(operation(stack));
        }
        else {
            System.out.println(stack.pollLast());
        }
    }

    // 우선순위에 맞게 계산
    private static void calculate() {
        String queueFirst = inputQueue.pollFirst();
        if (queueFirst.equals("(")) {
            stack.add(queueFirst);
            calculate();
        }
        else if (queueFirst.equals(")")) {
            // 큐에서 '(' 까지 꺼내서 우선순위에 맞게 계산
            ArrayDeque<String> operQueue = new ArrayDeque<>();
            while (!stack.peekLast().equals("(")) {
                operQueue.addFirst(stack.pollLast());
            }
            stack.pollLast(); // '(' 없애기
            String result = operation(operQueue);
            stack.add(result);
        }
        else {
            stack.add(queueFirst);
        }
    }

    private static String operation(ArrayDeque<String> queue) {
        ArrayDeque<String> multipleQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            String queueFirst = queue.pollFirst();
            if (queueFirst.equals("*") || queueFirst.equals("/")) {
                String operand1 = multipleQueue.pollLast();
                String operand2 = queue.pollFirst();
                multipleQueue.add(operand1 + operand2 + queueFirst);
            } else {
                multipleQueue.add(queueFirst);
            }
        }

        ArrayDeque<String> plusQueue = new ArrayDeque<>();
        while (!multipleQueue.isEmpty()) {
            String queueFirst = multipleQueue.pollFirst();
            if (queueFirst.equals("+") || queueFirst.equals("-")) {
                String operand1 = plusQueue.pollLast();
                String operand2 = multipleQueue.pollFirst();
                plusQueue.add(operand1 + operand2 + queueFirst);
            } else {
                plusQueue.add(queueFirst);
            }
        }
        return plusQueue.pollFirst();
    }
}
