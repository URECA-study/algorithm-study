import java.io.*;
import java.util.*;

public class Boj_2250 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Node> tree = new HashMap<>();
    static boolean[] hasParent;
    static int rootValue;

    static class Node {
        int value;
        Node left, right;

        Node (int value) {
            this.value = value;
        }
    } // class Node
 
    static int findHeight (Node node) {
        if (node == null) return 0;
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    } //findeHeight

    static int findWidth (Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxWidth = Math.max(maxWidth, levelSize);

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        } // while
        return maxWidth; 
    } //findWidth

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        hasParent = new boolean[n + 1]; 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken()); 

            tree.putIfAbsent(root, new Node(root));

            if (left != -1) {
                tree.putIfAbsent(left, new Node(left));
                tree.get(root).left = tree.get(left);
                hasParent[left] = true;
            }

            if (right != -1) {
                tree.putIfAbsent(right, new Node(right));
                tree.get(root).right = tree.get(right);
                hasParent[right] = true;
            }
        } // for

        for (int key : tree.keySet()) {
            if (!hasParent[key]) {
                rootValue = key;
                break;
            }
        }

        Node root = tree.get(rootValue);
        
        System.out.print(findHeight(root) + " " + findWidth(root));
        br.close();  
    } // main
}