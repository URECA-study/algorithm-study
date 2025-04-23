package brute_force.k0000k;

import java.io.*;
import java.util.*;

public class Bj15661 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[][] table;
    public static ArrayList<ArrayList<Integer>> combination = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeAllCombinations();

        int answer = Integer.MAX_VALUE;
        for (ArrayList<Integer> list : combination) {
            ArrayList<Integer> anotherTeam = findAnotherTeam(list);
            int power1 = calcPower(list);
            int power2 = calcPower(anotherTeam);
            int diff = Math.abs(power2 - power1);
            answer = Math.min(answer, diff);
        }

        System.out.println(answer);
    }

    private static void makeAllCombinations() {
        for (int i = 1; i <= table.length / 2; i++) {
            // 0 ~ (n - 1)에서 i개 조합
            makeCombination(i, 0, new ArrayList<>());
        }
    }

    private static void makeCombination(int i, int cnt, ArrayList<Integer> list) {
        if (cnt > table.length) {
            return;
        }
        if (list.size() == i) {
            combination.add(list);
            return;
        }
        makeCombination(i, cnt + 1, new ArrayList<>(list));
        list.add(cnt);
        makeCombination(i, cnt + 1, new ArrayList<>(list));
    }

    private static ArrayList<Integer> findAnotherTeam(ArrayList<Integer> team) {
        ArrayList<Integer> anotherTeam = new ArrayList<>();
        int idx = 0;
        int num = 0;
        while (num < table.length) {
            if (idx < team.size() && num == team.get(idx)) {
                idx++;
                num++;
                continue;
            }
            anotherTeam.add(num);
            num++;
        }
        return anotherTeam;
    }

    private static int calcPower(ArrayList<Integer> team) {
        int result = 0;
        for (int i = 0; i < team.size(); i++) {
            int idxI = team.get(i);
            for (int j = i + 1; j < team.size(); j++) {
                int idxJ = team.get(j);
                result += table[idxI][idxJ];
                result += table[idxJ][idxI];
            }
        }
        return result;
    }
}
