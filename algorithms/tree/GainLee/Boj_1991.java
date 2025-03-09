import java.io.*;
import java.util.*;

public class Boj_1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Character, Node> tree = new HashMap<>();
    static int n;

    static class Node {
        char value;
        Node left, right;

        Node (char value) {
            this.value = value;
        }
    } // Node class

    static public void preorder (Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    } // preorder - 전위

    static public void inorder (Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    } // inorder - 중위

    static public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    } // postorder - 후위


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.putIfAbsent(root, new Node(root));

            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(root).left = tree.get(left);
            }

            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(root).right = tree.get(right);
            }
        } // for

        // 출력
        Node root = tree.get('A');
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        br.close();
    } // main
}