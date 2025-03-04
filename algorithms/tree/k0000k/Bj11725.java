package tree.k0000k;

import java.io.*;
import java.util.*;

class Node {
    int parent = 0;
    ArrayList<Integer> linkedNode = new ArrayList<>();
    ArrayList<Integer> child = new ArrayList<>();
}

public class Bj11725 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<Integer, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        init(n);
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).linkedNode.add(b);
            tree.get(b).linkedNode.add(a);
        }

        findParent(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(tree.get(i).parent);
        }
    }

    private static void findParent(int n) {
        Node parentNode = tree.get(n);
        for (Integer nodeIdx : parentNode.linkedNode) {
            if (nodeIdx != parentNode.parent) {
                Node childNode = tree.get(nodeIdx);
                childNode.parent = n;
                findParent(nodeIdx);
            }
        }
    }

    private static void init(int n) {
        for (int i = 1; i < n + 1; i++) {
            tree.put(i, new Node());
        }
    }
}
