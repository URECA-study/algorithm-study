package greedy.k0000k;

import java.io.*;
import java.util.*;

class Town implements Comparable<Town> {
    int location;
    int people;

    public Town(int location, int people) {
        this.location = location;
        this.people = people;
    }

    @Override
    public int compareTo(Town o) {
        return this.location - o.location;
    }
}

// 마을의 좌표마다 첨점을 가지면서 아래로 볼록한 그래프가 나온다
public class Bj2141 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Town[] towns;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        towns = new Town[n];
        StringTokenizer st;
        long slideSum = 0; // 주민의 수의 최댓값은 1,000,000,000이므로, 기울기는 long으로 선언
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            towns[i] = new Town(location, people);
            slideSum -= people; // 초기 기울기 (가장 왼쪽 구간 직선)
        }

        Arrays.sort(towns); // 좌표 순서대로 입력되지 않으므로 정렬

        // 구간별 기울기 계산
        int pointIdx = 0;
        for (int i = 0; i < towns.length; i++) {
            Town town = towns[i];
            slideSum += town.people * 2L;
            if (slideSum >= 0) { // 기울기가 양수가 되는 순간이 최솟값
                pointIdx = i;
                break;
            }
        }

        System.out.println(towns[pointIdx].location);

    }
}
