package data_structure2.moomin;

import java.io.*;
import java.util.*;

/**
 * 자바 문법을 잘 몰라서 시간이 지체되었던 문제..
 * recommend -1 명령에서 단순히 우선순위 큐를 toList나 toArray로 변경하였는데
 * 그럴 시에 순서가 보장되지 않다는 것을 알게됨!!!!! 긴 써치끝에...
 * 그래서 ArrayList로 해결함 :)
 */

public class G24939 {

    static int N, M, P, L;
    static TreeMap<Integer, PriorityQueue<Integer>> problems = new TreeMap<>((o1, o2) -> o2 - o1); // 난이도별로 구분되어 있는 문제집
    static HashMap<Integer, Integer> problemMap = new HashMap<>(); // 문제-레벨 Map

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 문제 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            inputProblems(P, L);
        }

        // M 입력받기
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // 명령 입력받기
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();

            if(prompt.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) == 1){
                    System.out.println(problems.get(problems.firstKey()).peek());
                    continue;
                }

                List<Integer> sortedList = new ArrayList<>(problems.get(problems.lastKey()));
                Collections.sort(sortedList);
                System.out.println(sortedList.get(0));
                continue;
            }

            if(prompt.equals("solved")){
                P = Integer.parseInt(st.nextToken());
                L = problemMap.get(P);
                problems.get(L).remove(P);
                problemMap.remove(P, L);

                if(problems.get(L).isEmpty()){
                    problems.remove(L);
                }
                continue;
            }

            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            inputProblems(P, L);
        }
    }

    public static void inputProblems(int p, int l){
        if(problems.containsKey(l)){
            problems.get(l).offer(p);
            problemMap.put(p, l);
            return;
        }
        problems.put(l, new PriorityQueue<>((o1, o2) -> o2 - o1));
        problems.get(l).add(p);
        problemMap.put(p, l);
    }
}
