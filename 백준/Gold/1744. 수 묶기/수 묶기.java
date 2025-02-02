import java.util.*;
import java.io.*;
public class Main {

    int N;
    int[] array;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    int answer;

    public void solve() {
        int countZero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                pq.add(array[i]);
                array[i] = 0;
            } else if (array[i] < 0) {
                pq2.add(array[i]);
                array[i] = 0;
            } else if (array[i] == 0) {
                countZero += 1;
            }
        }
        answer = 0;
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            answer += (x * y);
        }
        if (!pq.isEmpty()) {
            answer += pq.poll();
        }

        while (pq2.size() > 1) {
            int x = pq2.poll();
            int y = pq2.poll();
            answer += (x * y);
        }

        if (!pq2.isEmpty() && countZero <= 0) {
            answer += pq2.poll();
        }


        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N];

        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(bf.readLine());
    }
    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
