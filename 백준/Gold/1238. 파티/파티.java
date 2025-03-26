import java.util.*;
import java.io.*;
public class Main {
    int N;
    int M;
    int X;

    int[][] graph;
    PriorityQueue<int[]> q = new PriorityQueue<>((((o1, o2) -> {
        return o1[0] - o2[0];
    })));

    public void solve() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            q.clear();
            int[] visited = new int[N];
            Arrays.fill(visited, 0);

            // cost, 현재 정점
            int goX = 0;
            q.add(new int[] {0, i});
            while (!q.isEmpty()) {
                int[] data = q.poll();
                if (data[1] == (X-1)) {
                    goX = data[0];
                    break;
                }
                if (visited[data[1]] == 1)
                    continue;
                visited[data[1]] = 1;
                for (int j = 0; j < N; j++) {
                    if (graph[data[1]][j] > 0) {
                        q.add(new int[] {data[0] + graph[data[1]][j], j});
                    }
                }
            }

            visited = new int[N];
            Arrays.fill(visited, 0);
            q.clear();

            int goHome = 0;
            q.add(new int[] {0, X-1});
            while (!q.isEmpty()) {
                int[] data = q.poll();
                if (data[1] == i) {
                    goHome = data[0];
                    break;
                }
                if (visited[data[1]] == 1)
                    continue;
                visited[data[1]] = 1;
                for (int j = 0; j < N; j++) {
                    if (graph[data[1]][j] > 0) {
                        q.add(new int[] {data[0] + graph[data[1]][j], j});
                    }
                }
            }
//
//            System.out.print((i+1) + "->" + X + ": " + goX + " ");
//            System.out.println(X + "->" + (i+1) + ": " + goHome);

            answer = Math.max(answer, goX + goHome);
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(graph[i], -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[A-1][B-1] = cost;
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
