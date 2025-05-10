import java.io.*;
import java.util.*;

class BJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] arr = new long[N];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(token.nextToken());
        }
        Arrays.sort(arr);
        long a = 0;
        long b = 0;
        long c = 0;
        long min = Long.MAX_VALUE;

        for(int i=0; i<N-2; i++) {
            long fix = arr[i];

            int left = i+1;
            int right = N-1;
            while(left<right) {

                long sum = arr[left] + arr[right] + fix;
                if(min > Math.abs(sum)) {
                    a = fix;
                    b = arr[left];
                    c = arr[right];
                    min = Math.abs(sum);
                }

                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    System.out.println(a + " " + b + " " + c);
                    System.exit(0);
                }
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}