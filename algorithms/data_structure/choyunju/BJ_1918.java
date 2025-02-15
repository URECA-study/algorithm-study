//no.15 - 1918
import java.io.*;
import java.util.*;

class BJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        char[] c = reader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<c.length; i++) {
            char now = c[i];
            if(now >='A' && now <='Z') {
                builder.append(now+"");
            }
            else {
                if(now == '(') {
                    stack.push(now);
                }
                else if(now == ')') {
                    while(!stack.isEmpty() && stack.peek()!='(') {
                        builder.append(stack.pop()+"");
                    }
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                else {
                    while(!stack.isEmpty() && priority(now) >= priority(stack.peek()) ) {
                        builder.append(stack.pop()+"");
                    }
                    stack.add(now);
                }
            }
        }
        while(!stack.isEmpty()) {
            builder.append(stack.pop()+"");
        }
        System.out.println(builder);
    }
    public static int priority(char op) {
        if(op=='+' || op=='-') {
            return 2;
        } else if(op=='*' || op=='/') {
            return 1;
        } return 3;
    }
}