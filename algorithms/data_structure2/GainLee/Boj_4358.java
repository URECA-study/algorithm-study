package data_structure2.GainLee;

import java.io.*;
import java.util.*;

public class Boj_4358 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String tree = " ";
        double total = 0.0;

        // 입력
        while ((tree = br.readLine()) != null) {
            // 해당 tree가 나오면 1씩 더함
            // 만약 해당 tree가 없을 경우 default 0 으로 설정 후 1을 더함
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            total++;
        } // while

        // 사전 순 정렬
        List<String> trees = new ArrayList<>(map.keySet());
        Collections.sort(trees);
        StringBuilder sb = new StringBuilder();
        for (String t : trees) {
            double percentage = ((double) map.get(t) / total) * 100.0;
            sb.append(t).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }
        System.out.print(sb);
    br.close();
    } // main
}