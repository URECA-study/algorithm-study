package data_structure.k0000k;

import java.io.*;

public class Bj10799 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] chars = input.split("");

        int answer = 0;
        int current = 0; // 현재 스택에 들어있는 '('의 수
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equals("(")) {
                if (chars[i + 1].equals(")")) {
                    answer += current;
                    i++;
                }
                else {
                    current += 1;
                    answer += 1;
                }
            }
            else if (chars[i].equals(")")) {
                current -= 1;
            }
        }
        System.out.println(answer);
    }
}
