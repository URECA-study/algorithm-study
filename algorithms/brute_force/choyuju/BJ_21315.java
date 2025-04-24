import java.io.*;
import java.util.*;

class BJ_21315 {
    static int[] arr;
    static Deque<Integer> before;
    static LinkedList<Integer> temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());
        arr = new int[N];

        LinkedList<Integer> list = new LinkedList<>();

        //초기 상태 저장
        for(int i=1; i<=N; i++) {
            list.add(i);
        }
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int limit = (int)(Math.log(N) / Math.log(2));
        for(int k1=1; k1<=limit; k1++) {
            for(int k2=1; k2<=limit; k2++) {
                temp = new LinkedList<>();
                for(int i=0; i<N; i++) {
                    temp.add(list.get(i));
                }
                // 카드 두 번 섞기
                mixCard(k1);
                mixCard(k2);

                boolean flag = false;
                for(int i=0; i<N; i++) {
                    if(arr[i] != temp.get(i)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    System.out.println(k1 + " " + k2);
                    System.exit(0);
                }
            }
        }
    }

    static void mixCard(int k) {
        int cnt=0;
        // 첫 번째 단계
        for(int i=1; i<=(int)Math.pow(2, k); i++) {
            int n = temp.pollLast();
            temp.addFirst(n);
        }
        cnt = (int)Math.pow(2, k);

        // 두 번째 이후부터 단계
        for(int i=2; i<=k+1; i++) {
            for(int j=1; j<=(int)Math.pow(2, k-i+1); j++) {
                int n = temp.remove(cnt-1);
                temp.addFirst(n);
            }
            cnt = (int)Math.pow(2, k-i+1);
        }
    }
}