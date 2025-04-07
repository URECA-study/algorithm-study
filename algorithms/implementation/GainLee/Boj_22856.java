package implementation.GainLee;

import java.io.*;
import java.util.*;

public class Boj_22856 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Node> tree = new HashMap<>();
    static int n;
    static int cnt = 0;
    static int[] rightmost = new int[n+1];

    static class Node {
        int root;
        Node left, right;
        Node (int root) {
            this.root = root;
        }
    } // class - Node

    static void likeInorder (Node node) {

        if (node == null) {
            return;
        }
        if (node.left != null) {
            likeInorder(node.left);
            cnt += 2;
        }
        if (node.right != null) {
            likeInorder(node.right);
            cnt += 2;
        }
    } // 유사 중위 순회

    static int count (Node node, int cnt_node){
        while (node.right != null) {
            cnt_node--;
            node = node.right;
        }
        return cnt_node;
    } // root 기준 맨 오른쪽에 있는 자식노드의 갯수만큼 cnt 감소

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.putIfAbsent(root, new Node(root));
            if (left != -1) {
                tree.putIfAbsent(left, new Node(left));
                tree.get(root).left = tree.get(left);
            }
            if (right != -1) {
                tree.putIfAbsent(right, new Node(right));
                tree.get(root).right = tree.get(right);
            }
        }

        Node node = tree.get(1);
        likeInorder(node);
//        count(node, cnt);
        System.out.println(count(node, cnt));
    } // main
}
