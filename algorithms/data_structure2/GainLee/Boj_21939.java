package data_structure2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_21939 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeSet<int[]> problems = new TreeSet<>((a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        else return a[1] - b[1];});
    static HashMap<Integer, Integer> problem_info = new HashMap<>();
    static int N, M;

    public static void main (String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pro_num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problems.add(new int[] {pro_num, level});
            problem_info.put(pro_num, level);
        } // for

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (Objects.equals(cmd, "recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    System.out.println(problems.last()[0]);
                } else if (x == -1) {
                    System.out.println(problems.first()[0]);
                }
            } else if (Objects.equals(cmd, "add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                problems.add(new int[] {p, l});
                problem_info.put(p,l);
            } else if (Objects.equals(cmd, "solved")){
                int p = Integer.parseInt(st.nextToken());
                int l = problem_info.getOrDefault(p, -1);
//                System.out.println(l);
                if (l != -1) {
//                    System.out.println(problems);
                    problems.remove(new int[] {p, l}); //
                    problem_info.remove(p);
                }

            }

        } // for
        br.close();
    } // main
}