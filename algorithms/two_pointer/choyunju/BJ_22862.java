import java.io.*;
import java.util.*;

class BJ_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];

        token = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int[] count = new int[2]; //0=짝수, 1=홀수
        int max = 0;
        int start = 0;
        int end = 0;
        while(start<N && end<N) {
            int num = arr[end];
            //짝수일 경우
            if(num%2 == 0) {
                count[0]++;
                end++;
            } else {  //홀수일 경우
                if(count[1] < K) {  //만약 홀수의 개수가 앚기 K보다 작다면
                    count[1]++;
                    end++;
                } else {  //K보다 홀수의 개수가 크다면
                    if(max < count[0]) {
                        max = count[0];
                    }
                    //start 인덱스가 짝수일 경우 짝수의 개수를 1 빼줌
                    if(arr[start]%2 == 0) {
                        count[0]--;
                    } else {  //start 인덱스가 홀수일 경우 홀수의 개수를 1 빼줌
                        count[1]--;
                    }
                    start++;  //start 증가
                }
            }
        }

        if(max < count[0]) {
            max = count[0];
        }
        System.out.println(max);
    }
}