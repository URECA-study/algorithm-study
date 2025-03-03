package tree.moomin;

import java.io.*;
import java.util.*;

public class S9934 {

    static int K;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // K 입력받기
        K = Integer.parseInt(st.nextToken());

        // 빌딩 입력받기
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 배열 선언
        visited = new boolean[list.size()];

        // 방문 시작
        int level = list.size();
        for(int i = 1; i<=K; i++){
            level = level / 2;
            for(int j = level; j<list.size(); j += level+1){
                if(visited[j] == true) continue;
                visited[j] = true;
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
