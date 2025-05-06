import java.io.*;
import java.util.*;

class BJ_20444 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        long N = Long.parseLong(token.nextToken());
        long K = Long.parseLong(token.nextToken());

        long left = 0;
        long right = N/2;
        boolean isFlag = false;
        while(left <= right) {
            long mid = (left+right)/2;
            long count = (mid+1) * (N-mid+1);

            if(count < K) {
                left = mid+1;
            } else if(count > K) {
                right = mid-1;
            } else {
                isFlag = true;
                break;
            }
        }

        if(isFlag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}