import java.util.*;
import java.io.*;
public class Main {

    int V;
    int E;
    int[][] edges;
    int[] parent;

    public int findParent(int node) {
        if (node != parent[node])
            parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public void solve() {
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        long answer = 0;

        for (int i = 0; i < edges.length; i++) {
            int x_parent = findParent(edges[i][0]);
            int y_parent = findParent(edges[i][1]);

            if (x_parent != y_parent) {
                parent[y_parent] = x_parent;
                answer += edges[i][2];
            }
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, ((o1, o2) -> {
            return o1[2] - o2[2];
        }));
    }

    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
