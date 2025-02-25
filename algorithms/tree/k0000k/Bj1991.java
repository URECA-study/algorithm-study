package tree.k0000k;

import java.io.*;
import java.util.*;

class Node {
    String name = "";
    String[] child;

    public Node(String name, String[] arr) {
        this.name = name;
        this.child = arr;
    }
}

public class Bj1991 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<String, Node> tree = new HashMap<>();
    public static boolean[] preorder;
    public static boolean[] inorder;
    public static boolean[] postorder;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(node, new Node(node, new String[]{left, right}));
        }

        preorder = new boolean[n + 1];
        preorder("A");
        System.out.println();

        inorder = new boolean[n + 1];
        inorder("A");
        System.out.println();

        postorder = new boolean[n + 1];
        postorder("A");
    }

    // 루트 - 왼쪽 - 오른쪽
    private static void preorder(String nodeIdx) {
        Node node = tree.get(nodeIdx);
        System.out.print(node.name);
        for (String str : node.child) {
            if (str.equals(".")) {
                continue;
            }
            preorder(str);
        }
    }

    // 왼쪽 - 루트 - 오른쪽
    private static void inorder(String nodeIdx) {
        Node node = tree.get(nodeIdx);
        String left = node.child[0];
        String right = node.child[1];
        if (!left.equals(".")) {
            inorder(left);
        }
        System.out.print(nodeIdx);
        if (!right.equals(".")) {
            inorder(right);
        }
    }

    // 왼쪽 - 오른쪽 - 루트
    private static void postorder(String nodeIdx) {
        Node node = tree.get(nodeIdx);
        String left = node.child[0];
        String right = node.child[1];
        if (!left.equals(".")) {
            postorder(left);
        }
        if (!right.equals(".")) {
            postorder(right);
        }
        System.out.print(nodeIdx);
    }
}
