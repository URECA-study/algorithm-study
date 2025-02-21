package data_structure2.moomin;

import java.io.*;
import java.util.*;

public class G21944 {

    static int N, M, P, L, G;
    // 레벨 set
    static TreeSet<Integer> levelSet;
    // 문제 - 레벨 쌍
    static HashMap<Integer, Integer> pL = new HashMap<>();
    // 문제 - 알고리즘 쌍
    static HashMap<Integer, Integer> pG = new HashMap<>();

    // 알고리즘 별 - 난이도 분류표
    static HashMap<Integer, TreeSet<Integer>> AlgoByLevel = new HashMap<>();
    // 난이도별 문제집 - 난이도가 높은 순 + 문제 정렬은 내림차순
    static TreeMap<Integer, TreeSet<Integer>> problemsByLevel = new TreeMap<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 문제 입력받기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            inputProblemsByLevel(P, L, G);
            inputAlgoByLevel(G, L);
        }

        // M 입력받기
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // 명령 수행
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String prompt = st.nextToken();

            if(prompt.equals("recommend")){
                int algo = Integer.parseInt(st.nextToken());
                if(Integer.parseInt(st.nextToken()) == 1){
                    System.out.println(problemsByLevel.get(AlgoByLevel.get(algo).first()).first());
                    continue;
                }
                System.out.println(problemsByLevel.get(AlgoByLevel.get(algo).last()).last());
                continue;
            }

            if(prompt.equals("recommend2")){
                if(Integer.parseInt(st.nextToken()) == 1){
                    System.out.println(problemsByLevel.get(problemsByLevel.firstKey()).first());
                    continue;
                }
                System.out.println(problemsByLevel.get(problemsByLevel.lastKey()).last());
                continue;
            }

            if(prompt.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                levelSet = new TreeSet<>(problemsByLevel.keySet());
                levelSet.add(L);

                // 해당 난이도가 있으면
                if(problemsByLevel.containsKey(L)){
                    if(x == 1){
                        // 레벨에서 작은 문제 찾기
                        System.out.println(problemsByLevel.get(L).last());
                        continue;
                    }
                    if(levelSet.lower(L) == null){
                        System.out.println(-1);
                        continue;
                    }
                    // 레벨에서 큰 문제 찾기
                    System.out.println(problemsByLevel.get(levelSet.lower(L)).first());
                    continue;
                }
                // 해당 난이도가 없으면
                if(x == 1){
                    if(levelSet.higher(L) == null){
                        System.out.println(-1);
                        continue;
                    }
                    // 레벨에서 작은 문제 찾기
                    System.out.println(problemsByLevel.get(levelSet.higher(L)).last());
                    continue;
                }

                // 레벨에서 큰 문제 찾기
                if(levelSet.lower(L) == null){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(problemsByLevel.get(levelSet.lower(L)).first());
                continue;
            }

            if(prompt.equals("solved")){
                P = Integer.parseInt(st.nextToken());
                removeProblems(P);
                continue;
            }

            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            inputProblemsByLevel(P, L, G);
            inputAlgoByLevel(G, L);
        }
    }

    public static void inputProblemsByLevel(int p, int l, int g){
        pL.put(p, l);
        pG.put(p, g);
        if(problemsByLevel.containsKey(l)){
            problemsByLevel.get(l).add(p);
            return;
        }
        problemsByLevel.put(l, new TreeSet<>((o1, o2) -> o2 - o1));
        problemsByLevel.get(l).add(p);
    }

    public static void inputAlgoByLevel(int g, int l){
        if(AlgoByLevel.containsKey(g)){
            AlgoByLevel.get(g).add(l);
            return;
        }
        AlgoByLevel.put(g, new TreeSet<>((o1, o2) -> o2 - o1));
        AlgoByLevel.get(g).add(l);
    }

    public static void removeProblems(int p) {
        int l = pL.get(p);
        int g = pG.get(p);

        problemsByLevel.get(l).remove(p);
        AlgoByLevel.get(g).remove(l);
        pL.remove(p, l);
        pG.remove(p, g);

        if(AlgoByLevel.get(g).isEmpty()){
            AlgoByLevel.remove(g);
        }
        if(problemsByLevel.get(l).isEmpty()){
            problemsByLevel.remove(l);
        }
    }
}
