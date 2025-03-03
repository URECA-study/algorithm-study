package tree.moomin;

import java.io.*;
import java.util.*;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data){
        root = insertNode(root, data);
    }

    public TreeNode insertNode(TreeNode cur, int data) {
        // 새로운 노드 삽입
        if(cur == null) {
            cur = new TreeNode(data);
            return cur;
        }

        if(data <= cur.data) {
            cur.left = insertNode(cur.left, data);
            return cur;
        }

        cur.right = insertNode(cur.right, data);
        return cur;
    }

    public void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
}

public class G5639 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        // 트리 생성
        BinaryTree tree = new BinaryTree();

        // 트리에 노드 삽입
        while((input = br.readLine()) != null && !input.isEmpty()){
            tree.insert(Integer.parseInt(input));
        }

        // 후위 순회
        TreeNode root = tree.root;
        tree.postOrder(root);
    }
}
