import java.util.*;
import java.io.*;
public class Main {

    int N;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int answer;

    public void solve() {
        answer = 0;
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            answer += (x + y);
            pq.add(x + y);
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(bf.readLine()));
    }
    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
