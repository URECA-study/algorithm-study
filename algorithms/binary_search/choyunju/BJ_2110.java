import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[N-1] - arr[0] + 1;
        int result = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            int index = arr[0] + mid;
            int count = 0;
            for(int i=1; i<N; i++) {
                if(arr[i] >= index) {
                    count++;
                    index = arr [i] + mid;
                }
            }
            if(count >= M-1) {
                left = mid+1;
                result = mid;
            } else {
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}