package two_pointer.k0000k;

import java.io.*;
import java.util.*;

public class Bj20442 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        ArrayList<Integer> ruIdx = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("R")) {
                ruIdx.add(i);
            }
        }

        if (ruIdx.isEmpty()) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = ruIdx.size() - 1;
        int answer = 0;
        while (start <= end) {
            int leftSideK = ruIdx.get(start) - start;
            int rightSideK = input.length - 1 - ruIdx.get(end) - (ruIdx.size() - 1 - end);
            int result = 2 * Math.min(leftSideK, rightSideK) + (end - start) + 1;
            answer = Math.max(answer, result);
            if (leftSideK >= rightSideK) { // 왼쪽에 k가 더 많으면
                end--;
            }
            else if (leftSideK < rightSideK) { // 오른쪽에 k가 더 많으면
                start++;
            }
        }
        System.out.println(answer);
    }
}
