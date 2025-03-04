import java.io.*;
import java.util.*;

public class BJ_9934 {
    static int[] city;
    static int depth=0;  // 레벨(깊이)
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(reader.readLine());
        city = new int[(int)Math.pow(2, K)-1];
        String[] s = reader.readLine().split(" ");

        for(int i=0; i<s.length; i++) {
            city[i] = Integer.parseInt(s[i]);
        }
        // 각 레벨(깊이) 별로 도시를 저장하기 위한 list
        list = new ArrayList[K];
        for(int i=0; i<K; i++) {
            list[i] = new ArrayList<>();
        }

        int mid = city.length / 2;
        int root = city[city.length / 2];
        list[depth].add(root);
        depth++;
        int left = 0;
        int right = city.length - 1;
        getLevel(left, mid-1, depth);
        getLevel(mid+1, right, depth);

        for(int i=0; i<K; i++) {
            for(int n : list[i]) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void getLevel(int start, int end, int depth) {
        if(start>end) {
            return;
        }
        int mid = (start + end) / 2;
        list[depth].add(city[mid]);
        depth++;
        getLevel(start, mid-1, depth);
        getLevel(mid+1, end, depth);
    }
}