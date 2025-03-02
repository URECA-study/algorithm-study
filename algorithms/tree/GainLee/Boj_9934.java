import java.io.*;
import java.util.*;

public class Boj_9934 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int k;
    static ArrayList<Integer>[] tree ;
    static int city;
    static int[] inorder;

    static void buildTree (int left, int right, int level) {
        if (left > right || level >= k) return;

        int mid = (left + right) / 2;
        tree[level].add(inorder[mid]);
        
        buildTree(left, mid-1, level+1);
        buildTree(mid+1, right, level+1);
    }
    public static void main (String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, k) - 1;

        tree = new ArrayList[k];
        for (int i = 0; i < k ; i++) {
            tree[i] = new ArrayList<>();
        }
        inorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] =Integer.parseInt(st.nextToken());     
        } // for

        buildTree(0, n-1 , 0);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int num : tree[i]) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        } // for
        System.out.print(sb);
        br.close();
    } // main
}