import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int num;
    int level;

    public Problem(int num, int level) {
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
        // 난이도가 같다면 문제번호 오름차순 정렬
        if(this.level == o.level) {
            return this.num - o.num;
        } else {  // 난이도 오름차순 정렬
            return this.level - o.level;
        }
    }
}

public class BJ_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine()); //문제 수

        TreeSet<Problem> treeSet = new TreeSet<>();  // 문제를 저장하기 위한 treeSet
        HashMap<Integer, Integer> hashMap = new HashMap<>();  // 문제번호-난이도를 저장하기 위한 hashMap

        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(token.nextToken());
            int level = Integer.parseInt(token.nextToken());
            treeSet.add(new Problem(num, level));
            hashMap.put(num, level);
        }

        int M = Integer.parseInt(reader.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            String command = token.nextToken();

            if(command.equals("add")) {
                int num = Integer.parseInt(token.nextToken());
                int level = Integer.parseInt(token.nextToken());
                treeSet.add(new Problem(num, level));
                hashMap.put(num, level);
            }
            else if(command.equals("recommend")) {
                int x = Integer.parseInt(token.nextToken());
                // 가장 쉬운 문제 출력
                if(x == -1) {
                    builder.append(treeSet.first().num).append("\n");
                } else { // 가장 어려운 문제 출력
                    builder.append(treeSet.last().num).append("\n");
                }
            }
            else if(command.equals("solved")){
                int num = Integer.parseInt(token.nextToken());
                int level = hashMap.get(num);
                Problem solvedProblem = new Problem(num, level);
                treeSet.remove(solvedProblem);  // 해결 한 문제 제거
                hashMap.remove(num);
            }
        }
        System.out.println(builder);
    }
}