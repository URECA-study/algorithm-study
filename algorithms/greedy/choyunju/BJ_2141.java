import java.io.*;
import java.util.*;

class City implements Comparable<City>{
    int location;
    int people;

    public City(int location, int people) {
        this.location = location;
        this.people = people;
    }

    @Override
    public int compareTo(City o) {
        return this.location - o.location;
    }
}

class  BJ_2141{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<City> queue = new PriorityQueue<>();
        long sumPeople = 0;

        for(int i=0; i<N; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            sumPeople -= b;  // 초기 기울기는 무조건 음수
            queue.add(new City(a, b));
        }

        int postOffice = 0;
        while(!queue.isEmpty()) {
            City city = queue.poll();
            sumPeople = sumPeople + (city.people * 2);
            if(sumPeople >= 0) {
                postOffice = city.location;
                break;
            }
        }
        System.out.println(postOffice);

    }
}