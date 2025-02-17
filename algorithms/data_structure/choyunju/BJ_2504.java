import java.util.*;
import java.io.*;

public class BJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] c = reader.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int num = 1;
        boolean flag = true;
        for(int i=0; i<c.length; i++) {
            if(c[i] == '(') {
                stack.add(c[i]);
                num *= 2;
            }
            else if(c[i] == '[') {
                stack.add(c[i]);
                num *= 3;
            }
            else if(c[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if(c[i-1] == '(') {
                    result += num;
                }
                stack.pop();
                num /= 2;
            }
            else if(c[i] == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if(c[i-1] == '[') {
                    result += num;
                }
                stack.pop();
                num /= 3;
            }
        }
        if(flag && stack.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}