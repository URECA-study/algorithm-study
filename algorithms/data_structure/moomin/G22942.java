import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle {
    int name;
    int data;
    boolean open;

    public Circle(int name, int data, boolean open){
        this.name = name;
        this.data = data;
        this.open = open;
    }
}

public class G22942 {
    static int N;
    static List<Circle> list;
    static Stack<Circle> stack;

    public static void main(String[] args) throws IOException {

        // N과 원 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();

        // 입력받은 원을 반으로 쪼개서 저장 (괄호처럼 사용)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.add(new Circle(i, x - r, true));
            list.add(new Circle(i, x + r, false));
        }

        // stack 초기화
        stack = new Stack<>();

        // 전체 정렬
        Collections.sort(list, (o1, o2) -> o1.data - o2.data);

        // 하나씩 꺼내면서 짝 비교
        for(Circle c : list){

            if(c.open){
                stack.push(c);
                continue;
            }

            if(c.name == stack.peek().name){
                stack.pop();
                continue;
            }

            // 짝 안맞으면 NO
            if(c.name != stack.peek().name){
                System.out.println("NO");
                return;
            }
        }
        // 짝이 다 맞아서 무사히 반복 끝났으면 YES
        System.out.println("YES");
    }
}
