import java.io.*;
import java.util.*;

public class Boj_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static ArrayList<Integer>[] tree;
    static int[] preorder;
    static int[] postorder;

    static class Node {
        int value;
        Node left, right;

        Node (int value) {
            this.value = value;
        }

        void insert(int newValue) {
            if (newValue < this.value) {
                if (left == null) left = new Node(newValue);
                else left.insert(newValue);
            } else {
                if (right == null) right = new Node(newValue);
                else right.insert(newValue);
            }
        } // insert

    } // Node class


    static void preorder (Node node) {
        if (node == null) return;
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException{
        
        String input;
        Node root = null;

        while ((input = br.readLine()) != null && !input.isEmpty())  {
            int num = Integer.parseInt(input);
            if (root == null) root = new Node(num);
            else root.insert(num);
        } // while

        preorder(root);
        br.close();
    } // main
}
