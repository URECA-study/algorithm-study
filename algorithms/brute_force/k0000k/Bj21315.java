package brute_force.k0000k;

import java.io.*;
import java.util.*;


public class Bj21315 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] cards;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int maxK = findMaxK(n); // 최대 k값 찾기
        int[] init = makeInitArr(n); // 1, 2, 3, ... n 배열 생성
        for (int i = 1; i <= maxK; i++) {
            // 첫 번째 (2, i)-섞기
            int[] arr = shuffleCards(init.clone(), i);
            for (int j = 1; j <= maxK; j++) {
                // 두 번째 (2, j)-섞기
                int[] result = shuffleCards(arr.clone(), j);
                if (isEqualCardSet(result)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    private static int[] makeInitArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int findMaxK(int n) {
        int k = 1;
        int multiple = 2;
        while (multiple < n) {
            multiple *= 2;
            k += 1;
        }
        return k - 1;
    }

    private static int[] shuffleCards(int[] arr, int k) {
        int[] newArr = new int[arr.length];
        int powOf2 = (int) Math.pow(2, k);
        // 1번째 단계
        int startIdx = arr.length - powOf2;
        int idx = 0;
        for (int i = startIdx; i < arr.length; i++) {
            newArr[idx++] = arr[i];
        }

        idx = 0;
        for (int i = powOf2; i < arr.length; i++) {
            newArr[i] = arr[idx++];
        }

        // 이후 단계
        for (int i = 0; i < k; i++) {
            int half = powOf2 / 2;
            for (int j = 0; j < half; j++) {
                // newArr[j]와 newArr[j + half]를 스왑
                int temp = newArr[j];
                newArr[j] = newArr[j + half];
                newArr[j + half] = temp;
            }
            powOf2 /= 2;
        }

        return newArr;
    }

    private static boolean isEqualCardSet(int[] result) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
}
