import java.io.*;
import java.util.*;

class Node {
    int num;
    int left;
    int right;

    public Node(int num, int left, int right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

}

public class BJ_1991 {
    static StringBuilder builder;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        tree = new Node[N+1];

        for(int i=0; i<N; i++) {
            char[] c = reader.readLine().toCharArray();
            int n = (int)c[0] - 64;
            int left = 0;
            int right = 0;
            if(c[2] == '.') {
                left = 0;
            } else {
                left = (int)c[2] - 64;
            }
            if(c[4] == '.') {
                right = 0;
            } else {
                right = (int)c[4] - 64;
            }
            tree[n] = new Node(n, left, right);

        }

        preOrder(tree[1]);
        builder.append("\n");
        inOrder(tree[1]);
        builder.append("\n");
        postOrder(tree[1]);
        System.out.println(builder);
    }

    public static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        builder.append((char)(node.num + 64));
        preOrder(tree[node.left]);
        preOrder(tree[node.right]);
    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(tree[node.left]);
        builder.append((char)(node.num+64));
        inOrder(tree[node.right]);
    }

    public static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(tree[node.left]);
        postOrder(tree[node.right]);
        builder.append((char)(node.num + 64));
    }
}