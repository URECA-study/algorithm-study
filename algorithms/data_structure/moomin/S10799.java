import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10799 {

    public static void main(String[] args) throws IOException {

        Stack<String> stack = new Stack<>();
        int count = 0;

        // 쇠막대기 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        // 스택에 괄호 넣기
        for(int i = 0; i<sb.length(); i++){
            System.out.println(count);
            String s = sb.substring(i, i+1);

            // 막대기라면 push
            if(s.equals("(")){
                stack.push(s);
                continue;
            }

            // 막대기의 끝이라면 + 1(남은 조각)
            if(s.equals(")") && stack.peek().equals("(") && sb.substring(i-1, i).equals(")")) {
                stack.pop();
                count += 1;
                continue;
            }

            // 레이저라면 막대기 수만큼 자르기
            stack.pop();
            count += stack.size();
        }
        System.out.println(count);
    }
}
