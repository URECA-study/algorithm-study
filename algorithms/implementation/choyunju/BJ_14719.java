import java.io.*;
import java.util.*;

class BJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        int[] block = new int[W+1];
        int[] result = new int[W+1];

        token = new StringTokenizer(reader.readLine());
        for(int i=1; i<=W; i++) {
            block[i] = Integer.parseInt(token.nextToken());
        }
        for(int i=1; i<=W; i++) {
            result[i] = block[i];
        }

        for(int i=2; i<W; i++) {
            int start = i-1;
            int end = i+1;
            int now = i;
            while(1<=start && end<=W) {
                //현재 블록을 기준으로 왼쪽 부분에서 현재 블록보다 큰 블록으로 start를 이동시킨다.
                if(block[now] >= block[start]) {
                    start--;
                }
                //현재 블록을 기준으로 오른쪽 부분에서 현재 블록보다 큰 블록으로 end를 이동시킨다.
                else if(block[now] >= block[end]) {
                    end++;
                }
                else if(block[now] < block[start] && block[now] < block[end]) {
                    break;
                }
            }

            if(1<=start && end<=W) {
                //start와 end 중 작은 값을 지닌 블록을 선택한다.
                int min = Math.min(block[start], block[end]);
                //start+1 에서 end까지 결국 min값만큼 빗물이 채워지므로 해당 범위를 모두 min으로 채운다.
                for(int j=start+1; j<end; j++) {
                    result[j] = min;
                }
                i = end-1;
            }
        }

        int sum = 0;
        for(int i=1; i<=W; i++) {
            if(result[i] > block[i]) {
                sum += result[i] - block[i];
            }
        }
        System.out.println(sum);
    }
}