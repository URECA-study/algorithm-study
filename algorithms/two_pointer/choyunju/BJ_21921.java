import java.io.*;
import java.util.*;

class BJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());
        int[] arr = new int[N+1];
        int[] list = new int[N+1];
        token = new StringTokenizer(reader.readLine());

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int start = 1;
        int end = start + X - 1;

        int sum = 0;
        for(int i=start; i<=end; i++) {
            sum += arr[i];
        }
        list[end] = sum;

        int max = sum;

        while(end < N) {
            end++;
            list[end] = list[end-1] + arr[end] - arr[start];
            start++;
            if(max < list[end]) {
                max = list[end];
            }
        }

        int count = 0;
        for(int i=X; i<=N; i++) {
            if(list[i] == max) {
                count++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}