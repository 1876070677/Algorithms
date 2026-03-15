import java.io.*;
import java.util.*;

class Car implements Comparable<Car> {
    int index;
    int pos;
    int fuel;
    int dist;

    public Car(int index, int pos, int fuel, int dist) {
        this.index = index;
        this.pos = pos;
        this.fuel = fuel;
        this.dist = dist;
    }

    public int compareTo(Car o) {
        return this.dist - o.dist;
    }
}

public class Main {
    int N;
    int S;
    int[] cars;
    int[] fuel;

    Queue<Car> q = new LinkedList<>();
    boolean[] visited;

    public void solve() {
        int start = S - 1; // 0부터 시작이니까!.
        int leftMax = start;
        int rightMax = start;

        q.add(new Car(start, cars[start], fuel[start], 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Car c = q.poll();

            // 우방향.
            for (int i = rightMax + 1; i < N; i++) {
                if (visited[i]) continue;
                if (cars[i] <= c.pos + c.fuel) {
                    visited[i] = true;
                    q.add(new Car(i, cars[i], fuel[i], cars[i] - c.pos));
                    rightMax = Math.max(rightMax, i);
                    continue;
                }
                break;
            }

            // 좌방향.
            for (int i = leftMax - 1; i > -1; i--) {
                if (visited[i]) continue;
                if (cars[i] >= c.pos - c.fuel) {
                    visited[i] = true;
                    q.add(new Car(i, cars[i], fuel[i], c.pos - cars[i]));
                    leftMax = Math.min(leftMax, i);
                    continue;
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i]) sb.append(i + 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        cars = new int[N];
        fuel = new int[N];
        visited = new boolean[N];
        Arrays.fill(visited, false);

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cars[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}