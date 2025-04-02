import java.util.*;
import java.io.*;

class BJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(reader.readLine());

        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int[] numList = new int[100001];
        int start = 1;
        int end = start;
        int count = 0;
        int max =0;

        while(start <= N && end <= N) {
            if(numList[arr[end]] < K) {
                numList[arr[end]]++;
                count++;
                end++;
            } else {
                numList[arr[start]]--;
                start++;
                if(max < count) {
                    max = count;
                }
                count--;
            }
        }
        //end가 N이 되는 경우까지의 길이가 제일 클 수도있으므로 다시 비교한다.
        if(max < count) {
            System.out.println(count);
        } else {
            System.out.println(max);
        }

    }
}