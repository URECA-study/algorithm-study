package tree.k0000k;

import java.io.*;
import java.util.*;

class Node {
    int num;
    int leftIdx;
    int rightIdx;
    int location;
    int level;

    public Node(int num, int leftIdx, int rightIdx) {
        this.num = num;
        this.leftIdx = leftIdx;
        this.rightIdx = rightIdx;
    }
}

public class Bj2250 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Node[] tree;
    public static ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    public static int[] parent;
    public static int counter = 1;

    public static void main(String[] args) throws IOException {
        init(); // 입력, 자료구조 초기화

        int rootIdx = findRoot(); // 트리의 루트 찾기
        findLocation(rootIdx); // 각 노드의 열 번호 찾기
        findLevel(rootIdx); // 각 노드의 레벨 찾기

        // 최대길이 구하기
        int maxLevel = 1;
        int maxWidth = 0;
        for (int i = 1; i < levels.size(); i++) {
            ArrayList<Integer> list = levels.get(i);
            if (list.isEmpty()) {
                break;
            }
            // BFS 수행 시에 왼쪽 노드부터 리스트에 저장했으므로, 0번과 가장 끝 인덱스의 값이 길이의 최대
            int leftIdx = list.get(0);
            int rightIdx = list.get(list.size() - 1);
            int width = tree[rightIdx].location - tree[leftIdx].location + 1;
            if (width > maxWidth) {
                maxWidth = width;
                maxLevel = i;
            }
        }

        System.out.println(maxLevel + " " + maxWidth);
    }

    // 입력 처리, 자료구조 초기화, parent 배열 업데이트
    private static void init() throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            levels.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[idx] = new Node(idx, left, right);
            if (left != -1) {
                parent[left] = idx;
            }
            if (right != -1) {
                parent[right] = idx;
            }
        }
    }

    // 부모 노드가 없으면 root 노드
    private static int findRoot() {
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    // 중위 순회로 노드의 열 번호를 계산
    private static void findLocation(int rootIdx) {
        Node node = tree[rootIdx];
        if (node.leftIdx != -1) {
            findLocation(node.leftIdx);
        }
        node.location = counter++;
        if (node.rightIdx != -1) {
            findLocation(node.rightIdx);
        }
    }

    // BFS로 모든 노드의 레벨을 계산
    private static void findLevel(int rootIdx) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        tree[rootIdx].level = 1;
        levels.get(1).add(rootIdx);
        queue.add(tree[rootIdx]);
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.leftIdx != -1) {
                Node leftNode = tree[node.leftIdx];
                leftNode.level = node.level + 1;
                levels.get(leftNode.level).add(node.leftIdx);
                queue.add(leftNode);
            }
            if (node.rightIdx != -1) {
                Node rightNode = tree[node.rightIdx];
                rightNode.level = node.level + 1;
                levels.get(rightNode.level).add(node.rightIdx);
                queue.add(rightNode);
            }
        }
    }
}