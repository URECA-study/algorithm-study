package implementation.moomin;

import java.io.*;
import java.util.*;

class Node {
    int data;
    int left;
    int right;

    public Node(int data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class G22856 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    static HashMap<Integer, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        // 노드 입력받기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree.put(d, new Node(d, l, r));
        }

        // 유사 중위 순회
        left(tree.get(1).left);
        if(tree.get(1).left != -1){
            stack.push(1);
        }
        right(tree.get(1).right);

        System.out.println(stack.size());

    }

    // 왼쪽
    public static void left(int node){

        if(node == -1) {
            return;
        }

        if(stack.isEmpty() || stack.peek() != node) stack.push(node);
        left(tree.get(node).left);
        if(stack.isEmpty() || stack.peek() != node) stack.push(node);
        left(tree.get(node).right);
        if(stack.isEmpty() || stack.peek() != node) stack.push(node);
    }

    // 오른쪽
    public static void right(int node){

        if(node == -1) {
            return;
        }

        if(stack.isEmpty() || stack.peek() != node) stack.push(node);
        right(tree.get(node).left);
        if(stack.isEmpty() || stack.peek() != node) stack.push(node);
        right(tree.get(node).right);
    }
}
