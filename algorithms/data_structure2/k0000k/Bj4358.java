package data_structure2.k0000k;

import java.io.*;
import java.util.*;

public class Bj4358 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<String, Integer> distribute = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String input;
        int cnt = 0;
        while (true) {
            input = br.readLine();
            if (input == null) {
                break;
            }
            int val = distribute.getOrDefault(input, 0);
            distribute.put(input, val + 1);
            cnt++;
        }

        String[] answers = new String[distribute.size()];
        int idx = 0;
        for (String key : distribute.keySet()) {
            int count = distribute.get(key);
            double percent = ((double) count / cnt * 100);
            answers[idx++] = String.format("%s %.4f", key, percent);
        }
        Arrays.sort(answers);

        for (String str : answers) {
            System.out.println(str);
        }
    }
}
