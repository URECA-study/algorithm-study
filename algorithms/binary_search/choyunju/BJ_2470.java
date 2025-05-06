import java.io.*;
import java.util.*;

class BJ_2470 {
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int start = 0;
        int end = N-1;
        Arrays.sort(arr);
        binary_search(start, end);

    }

    public static void binary_search(int start, int end) {
        while(start < end) {
            int diff = arr[start] + arr[end];
            if(min > Math.abs(diff)) {
                min = Math.abs(diff);
                a = arr[start];
                b = arr[end];
            }
            //두 용액의 합이 음수인 경우
            if(diff < 0) {
                start++;
            }
            //두 용액의 합이 양수인 경우
            else if(diff > 0){
                end--;
            }
            else {
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}