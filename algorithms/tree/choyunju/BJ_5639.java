import java.io.*;
import java.util.*;

class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
        this.num = num;
        this.left = null;
        this.right = null;
    }

    public void insert(int num) {
        // 왼쪽으로 삽입
        if(num < this.num) {
            if(this.left == null) {
                this.left = new Node(num);
            } else {
                this.left.insert(num);
            }
        }
        // 오른쪽으로 삽입
        else {
            if(this.right == null) {
                this.right = new Node(num);
            } else {
                this.right.insert(num);
            }
        }
    }

}

class BJ_5639 {
    static Node tree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rootNum = Integer.parseInt(reader.readLine());
        tree = new Node(rootNum);
        String s;
        while((s=reader.readLine()) != null) {
            int num = Integer.parseInt(s);
            tree.insert(num);
        }

        postOrder(tree);
    }

    public static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}