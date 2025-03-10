package greedy.k0000k;

import java.io.*;
import java.util.*;

public class Bj16953 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (b > a) {
            if (b % 2 == 0) { // 짝수일때
                b /= 2;
                answer++;
            }
            else if (b % 10 == 1) { // 끝자리 1일때
                b = (b - 1) / 10;
                answer++;
            }
            else { // 끝자리가 1 이외의 홀수일때
                System.out.println(-1);
                return;
            }
        }

        if (b == a) {
            System.out.println(answer + 1);
        }
        else {
            System.out.println(-1);
        }
    }
}
