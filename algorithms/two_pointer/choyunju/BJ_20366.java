import java.io.*;
import java.util.*;

class BJ_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        //엘자의 눈덩이 선택
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int elsaSnow = arr[i] + arr[j];
                int start = 0;
                int end = N-1;

                while(start < end) {
                    if(start==i || start==j) {
                        start++;
                        continue;
                    } else if(end==i || end==j) {
                        end--;
                        continue;
                    }
                    int annaSnow = arr[start] + arr[end];
                    min = Math.min(min, Math.abs(elsaSnow - annaSnow));

                    //두 눈사람의 길이의 차이를 줄이기 위해
                    //안나의 눈사람이 크면 안나의 end를 감소
                    //안나의 눈사람이 작으면 안나의 start를 증가
                    //두 눈사람의 길이가 같으면 그래도 0 출력
                    if(annaSnow < elsaSnow) {
                        start++;
                    } else if(annaSnow > elsaSnow) {
                        end--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(min);
    }
}