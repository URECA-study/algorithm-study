package tree.moomin;

import java.io.*;
import java.util.*;

class Node {
    String data;
    String left;
    String right;

    public Node(String data, String left, String right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class S1991 {
    static int N;
    static HashMap<String, Node> tree = new HashMap<String, Node>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 입력 받기
        N = Integer.parseInt(st.nextToken());

        // 트리 입력받기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.put(data, new Node(data, left, right));
        }

        // 전위 순회
        sb = new StringBuilder();
        preorder("A");
        System.out.println(sb.toString());

        // 중위 순회
        sb = new StringBuilder();
        inorder("A");
        System.out.println(sb.toString());

        // 후위 순회
        sb = new StringBuilder();
        postorder("A");
        System.out.println(sb.toString());
    }

    public static void preorder(String n){
        if(n.equals(".")){
            return;
        }

        sb.append(n);
        preorder(tree.get(n).left);
        preorder(tree.get(n).right);
    }

    public static void inorder(String n){
        if(n.equals(".")){
            return;
        }

        inorder(tree.get(n).left);
        sb.append(n);
        inorder(tree.get(n).right);
    }

    public static void postorder(String n){
        if(n.equals(".")){
            return;
        }

        postorder(tree.get(n).left);
        postorder(tree.get(n).right);
        sb.append(n);
    }
}
