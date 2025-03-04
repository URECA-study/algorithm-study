import java.io.*;
import java.util.*;


class Node {
    int num;
    int left;
    int right;
    int row;
    int column;

    public Node(int num, int left, int right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

}

class BJ_2250 {
    static int row = 1;
    static int totalRow;
    static Node[] tree;
    static int column = 1;
    static ArrayList<Node>[] rowList;
    // 루트를 찾기 위해 부모 노드를 저장
    // 만약 저장된 값이 없으면 해당 인덱스가 루트
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        tree = new Node[N+1];
        rowList = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            rowList[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(token.nextToken());
            int left = Integer.parseInt(token.nextToken());
            int right = Integer.parseInt(token.nextToken());
            if(left == -1) {
                left = 0;
            } else {
                parent[left] = num;  // 자식 인덱스에 부모를 저장
            }

            if(right == -1) {
                right = 0;
            } else {
                parent[right] = num;  // 자식 인덱스에 부모를 저장
            }

            Node n = new Node(num, left, right);
            tree[num] = n;
        }
        int rootIndex = 0;
        for(int i=1; i<=N; i++) {
            if (parent[i] == 0) {
                rootIndex = i;
            }
        }
        row = 1;

        setRow(tree[rootIndex], row);
        setColumn(tree[rootIndex]);
        int max = 0;
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(rowList[i].size() >= 1) {
                Node start = rowList[i].get(0);
                Node end = rowList[i].get(rowList[i].size()-1);
                int diff = end.column - start.column + 1;
                if(max < diff) {
                    max = diff;
                    builder = new StringBuilder();
                    builder.append(i + " " + diff);
                }
            }
        }
        System.out.println(builder);
    }

    public static void setRow(Node node, int row) {
        if(node == null) {
            return;
        }
        node.row = row;
        rowList[row].add(node);
        row++;
        setRow(tree[node.left], row);
        setRow(tree[node.right], row);
    }

    public static void setColumn(Node node) {
        if(node == null) {
            return;
        }
        setColumn(tree[node.left]);
        node.column = column++;
        setColumn(tree[node.right]);
    }
}