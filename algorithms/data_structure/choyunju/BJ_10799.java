import java.io.*;
import java.util.*;

public class BJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s = reader.readLine().toCharArray();

        int total = 0;  //잘려진 조각의 총 개수

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length-1; i++) {
            if(s[i] == '(') {
                if(s[i+1] == '(') {
                    total++; //레이저가 아니므로 개수에 1 더함
                }
                stack.add(s[i]);
            } else {
                stack.pop();
                if(s[i-1] == '(') {
                    //레이저이므로 stack에 저장된 현재 막대 개수를 더함
                    total += stack.size();
                }
            }
        }
        System.out.println(total);
    }
}