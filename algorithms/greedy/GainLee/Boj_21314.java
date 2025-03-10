package greedy.GainLee;

import java.io.*;

public class Boj_21314 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String findMax(String list) {
        StringBuilder sb = new StringBuilder();
        int k_cnt = 0;
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == 'M') {
                if(i == list.length()-1) {
                    sb.append("1".repeat(k_cnt+1));
                }
                k_cnt++;
            } else {
                sb.append("5").append("0".repeat(k_cnt));
                k_cnt = 0;
            }
        }
        return sb.toString();
    }

    static String findMin(String list) {
        StringBuilder sb = new StringBuilder();
        int m_cnt = 0;
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == 'M') {
                m_cnt++;
            } else {
                if (m_cnt > 0) {
                    sb.append("1").append("0".repeat(m_cnt - 1));
                    m_cnt = 0;
                }
                sb.append("5");
            }
        }
        if (m_cnt > 0) {
            sb.append("1").append("0".repeat(m_cnt-1));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String mingyeom = br.readLine();
        System.out.println(findMax(mingyeom));
        System.out.println(findMin(mingyeom));
    } // main
}
