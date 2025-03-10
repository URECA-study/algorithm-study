package greedy.k0000k;

import java.io.*;
import java.util.*;

public class Bj1541 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<String> operands = new ArrayDeque<>();
    public static ArrayDeque<String> operation = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String statement = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < statement.length(); i++) {
            Character ch = statement.charAt(i);
            if (ch.equals('+') || ch.equals('-')) {
                operands.add(sb.toString());
                sb = new StringBuffer();
                operands.add(ch.toString());
            }
            else {
                sb.append(ch);
            }
        }
        operands.add(sb.toString());

        // 덧셈만 모두 계산
        while (!operands.isEmpty()) {
            String val = operands.pollFirst();
            if (val.equals("+")) {
                String operand1 = operation.pollLast();
                String operand2 = operands.pollFirst();
                int result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                operation.add(String.valueOf(result));
            }
            else if (val.equals("-")) {
                continue;
            }
            else {
                operation.add(val);
            }
        }

        // 남아있는 뺄셈들 모두 계산
        int answer = Integer.parseInt(operation.pollFirst());
        while (!operation.isEmpty()) {
            answer -= Integer.parseInt(operation.pollFirst());
        }

        System.out.println(answer);
    }
}
