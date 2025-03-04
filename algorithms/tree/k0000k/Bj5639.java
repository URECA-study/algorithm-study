package tree.k0000k;

import java.io.*;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void addNode(Node node, int value) {
        if (value < node.val) {
            if (node.left == null) {
                node.left = new Node(value);
                return;
            }
            addNode(node.left, value);
        }
        else {
            if (node.right == null) {
                node.right = new Node(value);
                return;
            }
            addNode(node.right, value);
        }
    }
}

public class Bj5639 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> preorders = new ArrayList<>();
    public static Node root;

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            preorders.add(Integer.parseInt(input));
        }

        root = new Node(preorders.get(0));
        Tree tree = new Tree(root);
        for (int i = 1; i < preorders.size(); i++) {
            tree.addNode(root, preorders.get(i));
        }

        postorder(root);
    }

    private static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }

        if (node.right != null) {
            postorder(node.right);
        }

        System.out.println(node.val);
    }
}
