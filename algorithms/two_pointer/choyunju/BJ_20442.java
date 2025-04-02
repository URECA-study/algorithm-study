import java.io.*;
import java.util.*;

class BJ_20442 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = reader.readLine().toCharArray();

        //R의 총 개수
        int rCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 'R') {
                rCount++;
            }
        }

        int left = 0;
        int right = arr.length - 1;
        int rK = 0;
        int lK = 0;
        int max = rCount; //max의 초기값은 R 전체의 총 개수와 같다

        while(left <= right) {
            if(lK < rK) {
                //left가 K라면 leftK의 개수를 증가시켜준다.
                if(arr[left] == 'K') {
                    lK++;
                    left++;
                }
                //left가 R이라면 현재까지의 leftK와 rightK 중 작은 값을 *2(양쪽에 있어야하므로) 한 후 현재 R의 개수를 더해준다.
                else if(arr[left] == 'R') {
                    max = Math.max(max, Math.min(lK, rK) * 2 + rCount);
                    left++;
                    rCount--;  //left를 이동시켰으므로 현재R의 개수에서 1을 빼준다
                }
            } else {
                if(arr[right] == 'K') {
                    rK++;
                    right--;
                } else {
                    max = Math.max(max, Math.min(lK, rK) * 2 + rCount);
                    rCount--;
                    right--;
                }
            }
        }
        System.out.println(max);
    }
}