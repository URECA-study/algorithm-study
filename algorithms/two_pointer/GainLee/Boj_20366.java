package two_pointer.GainLee;

import java.io.*;
import java.util.*;

public class Boj_20366 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] snowballs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snowballs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snowballs);

        int height = 1000000000;

        for (int elsa_start = 0; elsa_start < n-3; elsa_start++) {
            for (int elsa_end = n-1; elsa_end >= elsa_start+3; elsa_end--) {
                int elsa = snowballs[elsa_start] + snowballs[elsa_end];
                int anna_start = elsa_start+1;
                int anna_end = elsa_end-1;

                while (anna_start < anna_end) {
                    int anna = snowballs[anna_start] + snowballs[anna_end];
                    // anna의 눈사람이 더 작다면 anna_start 1 증가
                    // anna의 눈사람이 더 크다면 anna_end 1 감소
                    // 두 눈사람의 크기가 같다면 0 출력 후 종료
                    if (anna < elsa) anna_start++;
                    else if (anna > elsa) anna_end--;
                    else {
                        System.out.println(0);
                        System.exit(0);
                    }

                    height = Math.min(height, Math.abs(elsa - anna));
                } // while
            } // for - elsa_end
        } // for - elsa_start
        System.out.println(height);
    } // main
}
