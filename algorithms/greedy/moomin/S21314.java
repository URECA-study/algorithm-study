package greedy.moomin;

import java.io.*;
public class S21314 {
    static int count;
    static StringBuilder mk;
    static StringBuilder max = new StringBuilder();
    static StringBuilder min = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 민겸 수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mk = new StringBuilder(br.readLine());

        // 끝 입력하기
        mk.append("E");

        // 최댓값
        count = 0;
        for(int i = 0; i<mk.length(); i++){
            // 끝났다면
            if(mk.substring(i, i+1).equals("E")){
                if(count == 0){ break;}

                for(int j = 0; j<count; j++){
                    max.append("1");
                }
                break;
            }

            if(mk.substring(i, i+1).equals("M")){
                count++;
                continue;
            }

            max.append("5");
            for(int j = 0; j<count; j++){
                max.append("0");
            }
            count = 0;
        }

        // 최솟값
        count = 0;
        for(int i = 0; i<mk.length(); i++){
            // 끝났다면
            if(mk.substring(i, i+1).equals("E")){
                if(count == 0){ break; }

                min.append("1");
                for(int j = 1; j<count; j++){
                    min.append("0");
                }
                break;
            }

            if(mk.substring(i, i+1).equals("M")){
                count++;
                continue;
            }

            if(count == 0){
                min.append("5");
                continue;
            }

            min.append("1");
            for(int j = 1; j<count; j++){
                min.append("0");
            }
            min.append("5");
            count = 0;
        }

        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}
