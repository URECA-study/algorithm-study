import java.io.*;
import java.util.*;

class BJ_21314 {
    static String[] string;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        string = reader.readLine().split("");

        getMax();
        builder.append("\n");
        getMin();
        System.out.println(builder);

    }

    public static void getMin() {
        int[] num = new int[string.length];

        for(int i=0; i<string.length; i++) {
            String s = string[i];
            if(s.equals("M")) {
                num[i] = 1;  //우선 1을 저장
                int j = i-1;
                int end = -1;

                while(j>=0) {
                    if(num[j] == 5) {  //현재 M의 전 단계가 K일 경우 그대로 M은 1
                        break;
                    } else {  //현재 M의 전 단계가 M일 경우 0으로 변경
                        num[j] = 0;
                        end = j;
                        j--;
                    }
                }
                if(end != -1) {  //M이 연속될 경우 처음 M은 1이 되어야 함
                    num[end] = 1;
                    num[i] = 0;
                }

            } else if(s.equals("K")) {
                num[i] = 5;
            }
        }

        for(int i=0; i<string.length; i++) {
            builder.append(num[i]);
        }
    }

    public static void getMax() {
        int[] num = new int[string.length];
        for(int i=0; i<string.length; i++) {
            String s = string[i];
            if(s.equals("M")) {
                num[i] = 1;
            } else if(s.equals("K")) {
                num[i] = 5;
                int end = -1;
                int j = i-1;
                while(j >= 0 && num[j] == 1) {  //현재가 K이고 그 전이 M일 경우 M들을 모두 0으로 저장
                    num[j] = 0;
                    end = j;
                    j--;
                }
                if(end != -1) {  //M의 연속에서 가장 처음의 M을 5로 저장
                    num[i] = 0;
                    num[end] = 5;
                }
            }
        }
        for(int i=0; i<num.length; i++) {
            builder.append(num[i]);
        }
    }
}