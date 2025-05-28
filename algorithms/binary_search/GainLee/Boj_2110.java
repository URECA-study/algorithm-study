package binary_search.GainLee;

import java.io.*;
import java.util.*;

public class  Boj_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; static int c;
    static ArrayList<Integer> map = new ArrayList<>();


    static int canInstall(int distance) {
        int count = 1;
        int lastlocate = map.get(0);

        for (int i = 0; i < map.size(); i++) {
            int locate = map.get(i);

            // 현재 탐색하는 점의 위치와 직전에 설치했던 집의 위치간 거리가
            // 최소 거리(distance) 보다 크거나 같을 때 공유기 설치 개수를 늘려주고
            // 마지막 설치 위치를 갱신해준다.
            if (locate - lastlocate >= distance) {
                count++;
                lastlocate = locate;
            }
        }

        return count;
    } // canInstall

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            map.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(map);

        int low = 1;
        int high = map.get(n-1) - map.get(0) + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (canInstall(mid) < c) {
                high = mid;
            } else  {
                low = mid + 1;
            }

        }
        // upper bound는 탐색값을 초과하는 첫 번째 값을 가리키므로,
        // 1을 빼준 값이 조건식을 만족하는 최대값이 된다.
        System.out.println(low -1);


    } // main
}

