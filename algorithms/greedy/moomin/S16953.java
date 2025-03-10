package greedy.moomin;

import java.io.*;
import java.util.*;
public class S16953 {
    static int A, B;
    static int count = 1;
    public static void main(String[] args) throws IOException {

        // A B 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        // 양수라면 2로 나누기
        // 음수인데 끝이 1이라면 1 제거
        while(A<B){
            if(B % 2 == 0){
                B = B / 2;
                count++;
                continue;
            }

            StringBuilder s = new StringBuilder(String.valueOf(B));
            if(!s.substring(s.length()-1, s.length()).equals("1")){
                System.out.println(-1);
                return;
            }
            B = Integer.valueOf(s.substring(0,s.length()-1));
            count++;
        }
        if(A != B){
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }
}
