import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1966 {

    static int test, N, M;
    static int count;
    static Queue<int[]> queue;
    static ArrayList<Integer> rank;
    static int[] ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static int func() throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        rank = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int[] temp = new int[]{Integer.parseInt(st.nextToken()), i};
            queue.offer(temp);
            rank.add(temp[0]);
        }

        // 우선순위 sorting
        Collections.sort(rank, Collections.reverseOrder());
        count = 0;

        // 우선순위 높은 것 부터 remove
        while(!queue.isEmpty()){
            if(rank.get(0) != queue.peek()[0]){
                queue.add(queue.poll());
                continue;
            }

            if(queue.peek()[1] == M){
                count++;
                break;
            }

            queue.remove();
            rank.remove(0);
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException{

        // 테스트 케이스 수 입력 받기
        st = new StringTokenizer(br.readLine());

        test = Integer.parseInt(st.nextToken());

        // 정답 배열 초기화
        ans = new int[test];

        // 테스트케이스 입력받기
        for(int i = 0; i<test; i++){
            ans[i] = func();
        }

        for(int i : ans){
            System.out.println(i);
        }
    }
}
