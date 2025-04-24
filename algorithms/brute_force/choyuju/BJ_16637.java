import java.io.*;
import java.util.*;

class BJ_16637 {
    static int m, max;
    static int[] num;
    static String[] ope;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        m = N/2;
        max = Integer.MIN_VALUE;
        num = new int[m+1];
        ope = new String[m];
        String[] s = reader.readLine().split("");
        for(int i=0; i<s.length; i++) {
            if(i%2==0) {
                num[i/2] = Integer.parseInt(s[i]);
            } else {
                ope[i/2] = s[i];
            }
        }
        DFS(num[0], 0);
        System.out.println(max);
    }

    public static int execute(String ope, int n1, int n2) {
        if(ope.equals("*")) {
            return n1 * n2;
        } else if(ope.equals("+")) {
            return n1 + n2;
        } else {
            return n1 - n2;
        }
    }

    public static void DFS(int value, int index) {
        if(index>=m) {
            max = Math.max(max, value);
            return;
        }

        //괄호 없이 순서대로 연산하는 경우
        int value1 = execute(ope[index], value, num[index+1]);
        DFS(value1, index+1);

        //A*(B+C)처럼 현재 연산자의 다음 연산자를 미리 계산 후 현재 연산자를 연산하는 경우
        if(index+1 < m) {
            int value2 = execute(ope[index+1], num[index+1], num[index+2]);
            DFS(execute(ope[index], value, value2), index+2);
        }
    }
}