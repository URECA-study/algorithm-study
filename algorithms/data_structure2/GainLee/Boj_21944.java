package data_structure2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_21944 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeSet<int []> problem_info = new TreeSet<>((a, b) -> {
        if (a[1] == b[1]) return a[2] - b[2];
        else return a[1] - b[1];
    }); // 문제의 모든 정보를 저장
    static HashMap<Integer, TreeMap<Integer, Integer>> algorithm = new HashMap<>();
    static HashMap<Integer, Integer> pro_level = new HashMap<>();
    static HashMap<Integer, Integer> pro_algo = new HashMap<>();

    public static void main (String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());  // 문제 번호
            int l = Integer.parseInt(st.nextToken());  // 난이도
            int g = Integer.parseInt(st.nextToken());  // 알고리즘 분류

            problem_info.add(new int[] {p, l, g});
            algorithm.putIfAbsent(g, new TreeMap<>());
            algorithm.get(g).put(p, l);
            pro_level.put(p, l);
            pro_algo.put(p, g);

        } // for

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (Objects.equals(cmd, "recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    System.out.println(algorithm.get(g).lastEntry().getKey());
                } else if (x == -1) {
                    System.out.println(algorithm.get(g).firstEntry().getKey());
                }
            }else if (Objects.equals(cmd, "recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    System.out.println(problem_info.last()[0]);
                } else if (x == -1) {
                    System.out.println(problem_info.first()[0]);
                }
            } else if (Objects.equals(cmd, "recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    int[] result = problem_info.ceiling(new int[]{0, l, 0});
                    if (result != null) {
                        System.out.println(result[0]);
                    } else {
                        System.out.println(-1);
                    }
                } else if (x == -1) {
                    int[] result = problem_info.floor(new int[]{0, l, 0});
                    if (result != null) {
                        System.out.println(result[0]);
                    } else {
                        System.out.println(-1);
                    }
                }
            } else if (Objects.equals(cmd, "add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                problem_info.add(new int[] {p, l, g});
                algorithm.get(g).put(p, l);
                pro_level.put(p, l);
                pro_algo.put(p, g);
            } else if (Objects.equals(cmd, "solved")){
                
                int p = Integer.parseInt(st.nextToken());
                int l = pro_level.getOrDefault(p, -1);
                int g = pro_algo.getOrDefault(p, -1);
                if (l != -1 && g != -1) {
                    Iterator<int[]> it = problem_info.iterator();
                    while (it.hasNext()) {
                        int[] prob = it.next();
                        if (prob[0] == p && prob[1] == l && prob[2] == g) {
                            it.remove();
                            break;
                        }
                    }
                    if (algorithm.containsKey(g)) {
                        algorithm.get(g).remove(p);
                        if (algorithm.get(g).isEmpty()) {
                            algorithm.remove(p);
                        }
                    }
                    pro_level.remove(p);
                    pro_algo.remove(p);
                }
            }
        } // for
        br.close();
    } // main
}