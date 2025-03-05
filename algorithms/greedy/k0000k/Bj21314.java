package greedy.k0000k;

import java.io.*;

public class Bj21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        findMax(input);
        findMin(input);
    }

    private static void findMax(String input) {
        StringBuffer numberStr = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch.equals('K')) { // K일때
                System.out.print(5);
                bufferFlush(numberStr, 0);
                numberStr = new StringBuffer();
            }
            else if (i == input.length() - 1) { // 문자열 마지막에 등장하는 M일때
                numberStr.append(ch);
                bufferFlush(numberStr, 1);
            }
            else if (ch.equals('M')) { // 문자열 중간에 등장하는 M일때
                numberStr.append(ch);
            }
        }
        System.out.println();
    }

    private static void findMin(String input) {
        StringBuffer numberStr = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch.equals('K')) { // K일때
                if (numberStr.length() > 0) {
                    System.out.print(1);
                    numberStr.deleteCharAt(numberStr.length() - 1);
                    bufferFlush(numberStr, 0);
                }
                System.out.print(5);
                numberStr = new StringBuffer();
            }
            else if (i == input.length() - 1) { // 문자열 마지막에 등장하는 M일때
                System.out.print(1);
                numberStr.append(ch);
                numberStr.deleteCharAt(numberStr.length() - 1);
                bufferFlush(numberStr, 0);
            }
            else if (ch.equals('M')) { // 문자열 중간에 등장하는 M일때
                numberStr.append(ch);
            }
        }
        System.out.println();
    }

    // sb에 있는 길이만큼 number를 출력
    private static void bufferFlush(StringBuffer stringBuffer, int number) {
        int length = stringBuffer.length();
        for (int j = 0; j < length; j++) {
            System.out.print(number);
        }
    }
}
