
import java.io.*;
import java.util.*;

public class Boj_22942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int x, r;
    static ArrayList<int[]> circles = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            circles.add(new int[]{x-r, x+r});
        } // for

        Collections.sort(circles, (a, b) -> Integer.compare(a[0], b[0]));

        //정렬확인
        // for (int i=0; i<circles.size(); i++) {
        //    System.out.println(Arrays.toString(circles.get(i)));
        //}

        String res = "YES";

        for (int j = 1; j < n; j++) {
            // 이전 원의 끝이 현재 원의 시작보다 크다면 교점이 생김
            if (circles.get(j-1)[1] >= circles.get(j)[0]) {
                res = "NO";
            }
            // 이전 원의 시작이 현재 원의 시작보다 작고,
            // 이전 원의 끝이 현재 원의 끝보다 크다면 교점이 안생김
            if (circles.get(j-1)[0] < circles.get(j)[0] && circles.get(j-1)[1] > circles.get(j)[1] ) {
                res = "YES";
            }
            if (res == "NO") break;
        } // for j

        br.close();
        System.out.println(res);
    } // main
}