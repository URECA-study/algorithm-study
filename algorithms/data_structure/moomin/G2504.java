import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G2504 {

    public static void main(String[] args) throws IOException {

        Stack<String> stack = new Stack<>();
        int ans = 0;

        // 괄호 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        // 괄호 하나씩 탐색
        for (int i = 0; i < sb.length(); i++) {

            String s = sb.substring(i, i + 1);

            // 열린 괄호는 스택에 넣기
            if (s.equals("(") || s.equals("[")) {
                stack.push(s);
                continue;
            }

            // 닫힌 괄호인데 스택이 비어있다면 잘못된 입력
            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }

            // 닫힌 괄호인데 짝이 안 맞으면 종료
            if ((s.equals(")") && stack.peek().equals("[")) || (s.equals("]") && stack.peek().equals("("))) {
                System.out.println(0);
                return;
            }

            // 소괄호 결합일 때
            if (s.equals(")")) {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                    continue;
                }

                int sum = 0;
                String n = "";
                while (!stack.isEmpty()) {
                    n = stack.pop();
                    if (n.equals("(")) {
                        break;
                    }
                    if (n.equals("[")) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(n);
                }
                if(!n.equals("(")) {
                    System.out.println(0);
                    return;
                }
                stack.push(String.valueOf(sum * 2));
            }

            // 대괄호 결합일 때
            if (s.equals("]")) {
                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                    continue;
                }

                int sum = 0;
                String n = "";
                while (!stack.isEmpty()) {
                    n = stack.pop();
                    if (n.equals("[")) {
                        break;
                    }
                    if (n.equals("(")) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(n);
                }
                if(!n.equals("[")) {
                    System.out.println(0);
                    return;
                }
                stack.push(String.valueOf(sum * 3));
            }

        }

        // 스택이 비어 있으면 잘못된 입력
        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        // 최종 결과 계산
        for (String n : stack) {
            if(n.equals("(") || n.equals("[")){
                System.out.println(0);
                return;
            }
            ans += Integer.parseInt(n);
        }
        System.out.println(ans);
        }
    }
