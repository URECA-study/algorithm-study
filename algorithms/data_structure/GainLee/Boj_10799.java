import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack= new Stack<>();

    public static void main(String[] args) throws IOException {
        int res = 0;
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    stack.pop();
                    res += stack.size();
                } else if (s.charAt(i-1) != '(') {
                    res += 1;
                    stack.pop();
                }
            }
        } // for
        System.out.println(res);
        br.close();
    } // main
}
