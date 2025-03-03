package tree.moomin;

import java.io.*;
import java.util.*;

public class S11725 {
    static int N;
    static List<Integer>[] arr;
    static boolean[] visited;
    static TreeMap<Integer, Integer> parent = new TreeMap<>();
    public static void main(String[] args) throws IOException {

        // N(노드 갯수) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // arr 선언
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new TreeMap<>();

        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        // 노드 입력받기 -> 자신 - 부모 순서
        for(int i = 0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        for(int i = 1; i<=N; i++) {
            func(i);
        }

        for(int i: parent.values()){
            System.out.println(i);
        }
    }
    public static void func(int n) {
        // 큐 준비
        Queue<Integer> q = new LinkedList<>();

        // 방문처리
        visited[n] = true;
        q.add(n);

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 0; i<arr[temp].size(); i++){
                if (visited[arr[temp].get(i)] == true){
                    continue;
                }
                parent.put(arr[temp].get(i), temp);
                visited[arr[temp].get(i)] = true;
                q.add(arr[temp].get(i));
            }
        }
    }
}
