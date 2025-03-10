package greedy.GainLee;
import java.io.*;

public class Boj_1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] split_minus = input.split("-");

        int res = 0;

        String[] firstGroup = split_minus[0].split("\\+");

        for (String num: firstGroup) {
            res += Integer.parseInt(num);

        }
        for (int i = 1; i < split_minus.length; i++) {
            String[] numbers = split_minus[i].split("\\+");
            int sum = 0;
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }
            res -= sum ;
        }

        System.out.println(res);

        br.close();
    } // main
}
