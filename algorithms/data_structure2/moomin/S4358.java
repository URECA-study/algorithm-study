package data_structure2.moomin;

import java.io.*;
import java.util.*;

/**
 * 사실 문제가 어려웠다기 보다는 항상 정해진 만큼의 입력만 받다가
 * 입력이 끝났음을 어떻게 알릴까 고민하다가 시간이 지체된 문제
 * 찾아보니 백준에서는 그냥 null 처리만 해줘도 답으로 인정해준다고 함.
 * 다만 인텔리제이 환경에서는 공백이 null 입력으로 받아드려지지 않아서
 * 종료 키워드 하나 정해놓고 테스트함 !
 */

public class S4358 {

    static String tree;
    static int size = 0;
    static HashMap<String, Integer> treeMap = new HashMap<>();
    static List<String> treeName;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // 나무 입력받기
        while((tree = br.readLine()) != null){

            if(!treeMap.containsKey(tree)) {
                treeMap.put(tree, 1);
                size++;
                continue;
            }

            treeMap.put(tree, treeMap.get(tree)+1);
            size++;
        }

        // 오름차순 정렬
        treeName = new ArrayList<>(treeMap.keySet());
        Collections.sort(treeName);

        // 백분율 계산
        for(int i = 0; i<treeName.size(); i++){
            String t = treeName.get(i);
            double percent = (double) treeMap.get(t) / size * 100;
            sb.append(t).append(" ").append(String.format("%.4f", percent)).append('\n');
        }

        // 정답 출력
        System.out.println(sb.toString().trim());
    }
}
