import java.io.*;
import java.util.*;

class BJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        //수열을 저장하는 변수 선언
        int[] numList = new int[N];
        for(int i=0; i<N; i++) {
            numList[i] = Integer.parseInt(reader.readLine());
        }

        StringBuilder builder = new StringBuilder();
        int index=0;
        int num = 1;

        for(int i=0; i<N; i++) {
            if(num <= numList[i]) {
                for(int j=num; j<=numList[i]; j++) {
                    stack.add(j);
                    builder.append("+\n");
                }
                num = numList[i]+1;
            }
            if(stack.peek() == numList[i]) {
                stack.pop();
                builder.append("-\n");
            } else {
                builder = new StringBuilder();
                builder.append("NO\n");
                break;
            }

        }
        System.out.println(builder);
    }
}