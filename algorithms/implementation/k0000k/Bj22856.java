package implementation.k0000k;

import java.io.*;
import java.util.*;

class Node {
    int val;
    int left;
    int right;

    public Node(int val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Bj22856 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static Node[] tree;
    public static int answer = 0;
    public static int cnt = 0; // 방문 완료한 노드의 갯수

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        for (int i = 0; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[val] = new Node(val, left, right);
        }

        traverse(1);
    }

    public static void traverse(int idx) {
        Node node = tree[idx];
        if (node.left != -1) {
            answer++;
            traverse(node.left);
            answer++;
        }
        cnt++;
        if (cnt == tree.length - 1) { // 순회가 끝나면 Early Return
            System.out.println(answer);
            return;
        }
        if (node.right != -1) {
            answer++;
            traverse(node.right);
            answer++;
        }
    }
}
