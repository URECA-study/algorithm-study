package data_structure.k0000k;

import java.io.*;
import java.util.*;

class Document {

    int number;
    int major;

    public Document(int number, int major) {
        this.number = number;
        this.major = major;
    }
}

public class Bj1966 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            ArrayDeque<Document> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int major = Integer.parseInt(st.nextToken());
                queue.add(new Document(j, major));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document document = queue.poll();
                boolean flag = false;
                for (Document docs : queue) {
                    if (docs.major > document.major) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    queue.add(document);
                } else {
                    count++;
                    if (target == document.number) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
