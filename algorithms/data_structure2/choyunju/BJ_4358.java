import java.io.*;
import java.util.*;

class BJ_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String tree = "";
        double total = 0.0;

        while((tree=reader.readLine()) != null) {
            //해당 tree가 나오면 1씩 더해줌
            //만약 해당 tree가 없었을 경우 디폴트로 0 설정 후 1을 더해줌
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            total++;
        }

        //key 값으로 사전 순 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        StringBuilder builder = new StringBuilder();
        for(String s : keySet) {
            double ratio = map.get(s)/total * 100.0;
            builder.append(s + " " + String.format("%.4f", ratio)).append("\n");
        }
        System.out.println(builder);
    }
}