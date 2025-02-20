import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int num;
    int level;
    int algo;

    public Problem(int num, int level, int algo) {
        this.num = num;
        this.level = level;
        this.algo = algo;
    }

    @Override
    public int compareTo(Problem o) {
        //알고리즘 구분 없이 level 오름차순
        if(this.level == o.level) {
            return this.num - o.num;
        } else {
            return this.level - o.level;
        }
    }
}

public class BJ_21944 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine()); //문제 수

        TreeSet<Problem> totalSet = new TreeSet<>();  // 모든 문제를 저장
        TreeSet<Problem>[] algoSet = new TreeSet[101];  //알고리즘 별 문제 저장
        for(int i=1; i<=100; i++) {
            algoSet[i] = new TreeSet<>();
        }
        HashMap<Integer, Integer> levelMap = new HashMap<>();  // 문제번호-난이도를 저장
        HashMap<Integer, Integer> algoMap = new HashMap<>();  // 문제번호-알고리즘을 저장
        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(token.nextToken());
            int level = Integer.parseInt(token.nextToken());
            int algo = Integer.parseInt(token.nextToken());
            Problem problem = new Problem(num, level, algo);
            totalSet.add(problem);
            algoSet[algo].add(problem);
            levelMap.put(num, level);
            algoMap.put(num, algo);
        }

        int M = Integer.parseInt(reader.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            String command = token.nextToken();

            if(command.equals("add")) {
                int num = Integer.parseInt(token.nextToken());
                int level = Integer.parseInt(token.nextToken());
                int algo = Integer.parseInt(token.nextToken());
                Problem problem = new Problem(num, level, algo);
                totalSet.add(problem);
                algoSet[algo].add(problem);
                levelMap.put(num, level);
                algoMap.put(num, algo);
            }
            else if(command.equals("recommend")) {
                int algo = Integer.parseInt(token.nextToken());
                int x = Integer.parseInt(token.nextToken());
                // 해당 알고리즘에서 가장 쉬운 문제 출력
                if(x == -1) {
                    builder.append(algoSet[algo].first().num).append("\n");
                } else { // 해당 알고리즘에서 가장 어려운 문제 출력
                    builder.append(algoSet[algo].last().num).append("\n");
                }
            }
            else if(command.equals("recommend2")) {
                int x = Integer.parseInt(token.nextToken());
                // 알고리즘 상관없이 가장 쉬운 문제 출력
                if(x == -1) {
                    builder.append(totalSet.first().num).append("\n");
                } else {  // 알고리즘 상관없이 가장 어려운 문제 출력
                    builder.append(totalSet.last().num).append("\n");
                }
            }
            else if(command.equals("recommend3")) {
                int x = Integer.parseInt(token.nextToken());
                int level = Integer.parseInt(token.nextToken());
                if(x == -1) {
                    if(totalSet.floor(new Problem(0, level, 0)) == null) {
                        builder.append("-1\n");
                    } else {
                        builder.append(totalSet.floor(new Problem(0, level, 0)).num).append("\n");
                    }
                } else {
                    if(totalSet.ceiling(new Problem(0, level, 0)) == null) {
                        builder.append("-1\n");
                    } else {
                        builder.append(totalSet.ceiling(new Problem(0, level, 0)).num).append("\n");
                    }

                }
            }
            else if(command.equals("solved")){
                int num = Integer.parseInt(token.nextToken());
                int level = levelMap.get(num);
                int algo = algoMap.get(num);
                Problem solvedProblem = new Problem(num, level, algo);
                totalSet.remove(solvedProblem);  // 해결 한 문제 제거
                algoSet[algo].remove(solvedProblem);
                levelMap.remove(num);
                algoMap.remove(num);
            }
        }
        System.out.println(builder);
    }
}