package two_pointer.k0000k;

import java.io.*;
import java.util.*;

public class Bj20366 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] snows;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        snows = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snows[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snows);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                // i와 j는 고정해놓고 그 사이 구간에서 눈사람을 만든다.
                int firstHeight = snows[i] + snows[j];
                int start = i + 1;
                int end = j - 1;
                while (start < end) { // 투포인터 시작
                    int secondHeight = snows[start] + snows[end];
                    answer = Math.min(answer, Math.abs(firstHeight - secondHeight));
                    if (secondHeight > firstHeight) {
                        end--;
                    }
                    else if (secondHeight < firstHeight) {
                        start++;
                    }
                    else { // 두 눈사람의 키가 같으면 (i, j) 눈사람을 고정해둔 상태에서 더이상 최적을 찾을 수 없다.
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
