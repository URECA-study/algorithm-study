import java.io.*;
import java.util.*;

class BJ_1477 {
    static int[] arr;  // 휴게소의 위치 배열
    static int[] diffDistance;  //각 휴게소 별 거리차이 배열
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());
        //고속도로의 양 끝인 0과 L을 추가하기 위해 크기를 N+2로 지정
        arr = new int[N+2];
        arr[0] = 0;
        arr[N+1] = L;
        diffDistance = new int[N+1];
        token = new StringTokenizer(reader.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);

        //각 휴게소 별 거리의 차이를 구한다.
        for(int i=0; i<=N; i++) {
            diffDistance[i] = arr[i+1] - arr[i];
        }


        // 휴게소의 위치는 1~(L-1) 사이에 위치
        int left = 1;
        int right = L-1;
        int result = 0;

        while(left <= right) {
            int mid = (left+right)/2;
            int count = 0;
            for(int i=0; i<=N; i++) {
                count += diffDistance[i]/mid;
                // 0으로 나누어 떨어진 경우 이미 휴게소가 1개 지어진 경우이므로 -1을 해준다.
                if(diffDistance[i] % mid == 0) {
                    count--;
                }
            }

            if(count <= M) {
                right = mid-1;
                result = mid;
            } else {
                left = mid+1;

            }
        }
        System.out.println(result);

    }
}