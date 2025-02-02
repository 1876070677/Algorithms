import java.util.*;
import java.io.*;
public class Main {

    int T;
    long K;
    long[] fileSize;
    long answer;
    PriorityQueue<Long> pq = new PriorityQueue<>();

    public void solve() {
        answer = 0;
        pq.clear();
        for (int i = 0; i < K; i++) {
            pq.add(fileSize[i]);
        }
        while(pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            answer += x + y;
            pq.add(x + y);
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            K = Long.parseLong(br.readLine());
            fileSize = new long[(int) K];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                fileSize[j] = Integer.parseInt(st.nextToken());
            }
            solve();
        }
    }
    public void solution() throws IOException {
        input();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
