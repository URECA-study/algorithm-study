package data_structure2.moomin;

import java.util.*;
import java.io.*;

public class G21944 {

    static int N, M, P, L, G;

    // 문제 - 레벨 쌍
    static HashMap<Integer, Integer> pL = new HashMap<>();
    // 문제 - 알고리즘 쌍
    static HashMap<Integer, Integer> pG = new HashMap<>();

    // 알고리즘 별
    static HashMap<Integer, TreeSet<Integer>> AlgoByLevel = new HashMap<>();
    // 난이도별 문제집
    static TreeMap<Integer, TreeSet<Integer>> problemsByLevel = new TreeMap<>();

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
                    // 그 난이도의 문제의 알고리즘이 algo일 때!!
                    Iterator<Integer> iter = problemsByLevel.get(AlgoByLevel.get(algo).last()).descendingIterator();
                    while(iter.hasNext()) {
                        int problem = iter.next();
                        if (pG.get(problem) == algo) {
                            System.out.println(problem);
                            break;
                        }
                    }
                    continue;
                }
                Iterator<Integer> iter = problemsByLevel.get(AlgoByLevel.get(algo).first()).iterator();
                while(iter.hasNext()){
                    int problem = iter.next();
                    if(pG.get(problem) == algo){
                        System.out.println(problem);
                        break;
                    }
                }
                continue;
            }

            if(prompt.equals("recommend2")){
                if(Integer.parseInt(st.nextToken()) == 1){
                    System.out.println(problemsByLevel.get(problemsByLevel.lastKey()).last());
                    continue;
                }
                System.out.println(problemsByLevel.get(problemsByLevel.firstKey()).first());
                continue;
            }

            if(prompt.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                if(x == 1){
                    if(problemsByLevel.ceilingKey(L) == null){
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(problemsByLevel.get(problemsByLevel.ceilingKey(L)).first());
                    continue;
                }

                if(problemsByLevel.lowerKey(L) == null){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(problemsByLevel.get(problemsByLevel.lowerKey(L)).last());
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
        problemsByLevel.put(l, new TreeSet<>());
        problemsByLevel.get(l).add(p);
    }

    public static void inputAlgoByLevel(int g, int l){
        if(AlgoByLevel.containsKey(g)){
            AlgoByLevel.get(g).add(l);
            return;
        }
        AlgoByLevel.put(g, new TreeSet<>());
        AlgoByLevel.get(g).add(l);
    }

    public static void removeProblems(int p) {
        int l = pL.get(p);
        int g = pG.get(p);

        pL.remove(p, l);
        pG.remove(p, g);
        problemsByLevel.get(l).remove(p);

        if(problemsByLevel.get(l).isEmpty()){
            problemsByLevel.remove(l);
            AlgoByLevel.get(g).remove(l);

            if(AlgoByLevel.get(g).isEmpty()){
                AlgoByLevel.remove(g);
            }
            return;
        }

        Iterator<Integer> iter = problemsByLevel.get(l).iterator();
        while(iter.hasNext()){
            int problem = iter.next();
            if(pG.get(problem) == g){
                return;
            }
        }
        AlgoByLevel.get(g).remove(l);

        if(AlgoByLevel.get(g).isEmpty()){
            AlgoByLevel.remove(g);
        }
    }
}
