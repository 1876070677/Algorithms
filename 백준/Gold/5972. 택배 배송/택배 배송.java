import java.util.*;
import java.io.*;
public class Main {
    int N, M;
    ArrayList<int[]>[] graph;

    PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> {
        return o1[0] - o2[0];
    }));

    public void solve() {
        int answer = 1000 * 50000 + 1;
        int[] visited = new int[N];
        Arrays.fill(visited, 0);

        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] data = q.poll();
            int curr = data[1];
            int cost = data[0];

            if (curr == N-1) {
                answer = Math.min(answer, cost);
            }
            if (visited[curr] == 1)
                continue;
            visited[curr] = 1;
            for (int i = 0; i < graph[curr].size(); i++) {
                int[] nextData = graph[curr].get(i);

                int next = nextData[0];
                int c = nextData[1];
                q.add(new int[] {cost + c, next});
            }
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[x-1].add(new int[] {y-1, cost});
            graph[y-1].add(new int[] {x-1, cost});
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
