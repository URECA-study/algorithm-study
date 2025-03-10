package greedy.moomin;

import java.io.*;
import java.util.*;

public class S1541 {

    static ArrayList<Integer> arr = new ArrayList<>();
    static int ans;
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer temp;

        // 반복문 돌기
        while(st.hasMoreTokens()){
            String s = st.nextToken();

            if(s.contains("+")){
                temp = new StringTokenizer(s, "+");
                int sum = 0;
                while(temp.hasMoreTokens()){
                    sum += Integer.parseInt(temp.nextToken());
                }
                arr.add(sum);
                continue;
            }
            arr.add(Integer.parseInt(s));
        }

        // 가장 처음 원소의 값 꺼내고
        ans = arr.get(0);
        for(int i = 1; i<arr.size(); i++){
            ans -= arr.get(i);
        }
        System.out.println(ans);
    }
}
