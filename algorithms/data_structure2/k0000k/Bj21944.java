package data_structure2.k0000k;

import java.io.*;
import java.util.*;

class NewProblem {
    int number;
    int level;
    int group;

    public NewProblem(int number, int level, int group) {
        this.number = number;
        this.level = level;
        this.group = group;
    }
}

public class Bj21944 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static TreeSet<NewProblem> problemSortByLevel; // level -> number -> group 우선순위로 오름차순 정렬
    public static TreeSet<NewProblem> problemSortByGroup; // group -> level -> number 우선순위로 오름차순 정렬
    public static HashMap<Integer, Integer> levelMap = new HashMap<>();
    public static HashMap<Integer, Integer> groupMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        // 초기 문제 입력
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addProblem(st.nextToken(), st.nextToken(), st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];
            if (command.equals("add")) {
                addProblem(inputs[1], inputs[2], inputs[3]);
            }
            else if (command.equals("recommend")) { // 그룹이 g인 문제중에 가장 어렵거나 쉬운 문제
                int g = Integer.parseInt(inputs[1]);
                int c = Integer.parseInt(inputs[2]);
                command1Operation(g, c);
            }
            else if (command.equals("recommend2")) { // 그룹 상관없이 가장 어렵거나 쉬운 문제 출력
                int c = Integer.parseInt(inputs[1]);
                if (c == 1) {
                    System.out.println(problemSortByLevel.last());
                }
                else if (c == -1) {
                    System.out.println(problemSortByLevel.first());
                }
            }
            else if (command.equals("recommend3")) { // 난이도 L을 기준으로 가장 어렵거나 쉬운 문제
                int c = Integer.parseInt(inputs[1]);
                int l = Integer.parseInt(inputs[2]);
                command3Operation(c, l);
            }
            else if (command.equals("solved")) {
                int number = Integer.parseInt(inputs[1]);
                int level = levelMap.get(number);
                int group = groupMap.get(number);
                NewProblem target = new NewProblem(number, level, group);
                problemSortByGroup.remove(target);
                problemSortByLevel.remove(target);
            }
        }
    }

    private static void addProblem(String number, String level, String group) {
        int p = Integer.parseInt(number);
        int l = Integer.parseInt(level);
        int g = Integer.parseInt(group);
        NewProblem problem = new NewProblem(p, l, g);
        problemSortByLevel.add(problem);
        problemSortByGroup.add(problem);
        groupMap.put(p, g);
        levelMap.put(p, l);
    }

    private static void command1Operation(int group, int flag) {
        if (flag == -1) {
            NewProblem target = problemSortByGroup.higher(new NewProblem(0, 0, group));
            System.out.println(target);
        }
        else {
            NewProblem target = problemSortByGroup.lower(new NewProblem(0, 0, group + 1));
            System.out.println(target);
        }
    }

    private static void command3Operation(int flag, int level) {
        NewProblem target = null;
        if (flag == -1) { // 난이도 l보다 같거나 작으면서 가장 어려운 문제
            target = problemSortByLevel.lower(new NewProblem(0, level, 0));
        }
        else {
            target = problemSortByLevel.higher(new NewProblem(0, level, 0));
        }
        if (target == null) {
            System.out.println(-1);
            return;
        }
        System.out.println(target.number);
    }

    public static void init() {
        problemSortByLevel = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(NewProblem o1, NewProblem o2) {
                if (o1.level == o2.level) {
                    if (o1.number == o2.number) {
                        return o1.group - o2.group;
                    }
                    return o1.number - o2.number;
                }
                return o1.level - o2.level;
            }
        });

        problemSortByGroup = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(NewProblem o1, NewProblem o2) {
                if (o1.group == o2.group) {
                    if (o1.level == o2.level) {
                        return o1.number - o2.number;
                    }
                    return o1.level - o2.level;
                }
                return o1.group - o2.group;
            }
        });
    }

}
