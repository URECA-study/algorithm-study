import java.util.*;
import java.io.*;

public class G1918 {

    static Stack<String> stack = new Stack<>();
    static List<String> oList = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "(", ")"));
    static int[] oLevel = new int[]{1, 1, 2, 2, 3, 3};

    public static void main(String[] args) throws IOException{

        // 표기식 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder ans = new StringBuilder();

        for(int i= 0; i<sb.length(); i++){
            String s = sb.substring(i, i+1);

            // 알파벳이면 바로 정답에 +
            if(!oList.contains(s)){
                ans.append(s);
                continue;
            }

            // 스택이 비어있을때 s가 연산자이면 push
            if(stack.isEmpty()){
                stack.push(s);
                continue;
            }

            // s가 닫는 괄호일 경우 여는 괄호가 나올때까지 꺼내서 출력
            if(s.equals(")")){
                while(true){
                    if(stack.peek().equals("(")){
                        stack.pop();
                        break;
                    }
                    ans.append(stack.pop());
                }
                continue;
            }

            // stack의 peek보다 s가 우선순위가 높다면 push
            if(oLevel[oList.indexOf(s)] > oLevel[oList.indexOf(stack.peek())]){
                stack.push(s);
                continue;
            }

            // s가 낮거나 같은데 stack의 peek이 여는 괄호일 경우 pop하지 않음
            if(stack.peek().equals("(")){
                stack.push(s);
                continue;
            }

            // 낮다면 우선순위가 같아질때까지 pop 하고 정답에 +, s는 stack에 push
            while(!stack.isEmpty()){
                if(stack.peek().equals("(") || oLevel[oList.indexOf(stack.peek())] < oLevel[oList.indexOf(s)]){
                    break;
                }
                ans.append(stack.pop());
            }
            stack.push(s);
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        System.out.println(ans);
    }
}
