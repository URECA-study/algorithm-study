package data_structure2.k0000k;

import java.io.*;
import java.util.*;

class Problem {
    int number;
    int difficulty;

    public Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        return (this.number == ((Problem2) o).number);
    }
}

public class Bj21939 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Problem2> hardProblems;
    public static PriorityQueue<Problem2> easyProblems;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem2 problem = new Problem2(p, l);
            hardProblems.add(problem);
            easyProblems.add(problem);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            if (command.equals("add")) {
                int p = Integer.parseInt(inputs[1]);
                int l = Integer.parseInt(inputs[2]);
                Problem2 problem = new Problem2(p, l);
                hardProblems.add(problem);
                easyProblems.add(problem);
            }
            else if (command.equals("recommend")) {
                int c = Integer.parseInt(inputs[1]);
                if (c == 1) {
                    System.out.println(hardProblems.peek().number);
                }
                else if (c == -1) {
                    // 쉬운, 작은 문제 출력
                    System.out.println(easyProblems.peek().number);
                }
            }
            else if (command.equals("solved")) {
                int number = Integer.parseInt(inputs[1]);
                Problem2 problem = new Problem2(number, 0);
                hardProblems.remove(problem);
                easyProblems.remove(problem);
            }
        }
    }

    private static void init() {
        easyProblems = new PriorityQueue<>(new Comparator<Problem2>() {
            @Override
            public int compare(Problem2 o1, Problem2 o2) {
                if (o1.difficulty == o2.difficulty) {
                    return o1.number - o2.number;
                }
                return o1.difficulty - o2.difficulty;
            }
        });

        hardProblems = new PriorityQueue<>(new Comparator<Problem2>() {
            @Override
            public int compare(Problem2 o1, Problem2 o2) {
                if (o2.difficulty == o1.difficulty) {
                    return o2.number - o1.number;
                }
                return o2.difficulty - o1.difficulty;
            }
        });
    }
}
