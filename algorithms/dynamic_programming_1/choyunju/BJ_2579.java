import java.io.*;
import java.util.*;

class BJ_2579 {
    static int[] stairs;
    static int[] DP;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        stairs = new int[N+1];
        DP = new int[N+1];

        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        DP[1] = stairs[1];
        if(N>=2) {
            DP[2] = stairs[2] + stairs[1];
        }

        findMax();
        System.out.println(DP[N]);
    }

    public static void findMax() {
        for(int i=3; i<=N; i++) {
            DP[i] = Math.max(DP[i-2], DP[i-3] + stairs[i-1]) + stairs[i];
        }
    }
}