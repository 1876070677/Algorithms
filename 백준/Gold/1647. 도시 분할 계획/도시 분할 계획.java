import java.util.*;
import java.io.*;
public class Main {

    int N;
    int M;
    int[][] edges;
    int[] parent;

    public int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    public void solve() {
        parent = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;

        ArrayList<Integer> w = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int cost = edges[i][2];

            int x_parent = findParent(x);
            int y_parent = findParent(y);
            
            if (x_parent != y_parent) {
                w.add(cost);
                if (x_parent < y_parent)
                    parent[y_parent] = x_parent;
                else
                    parent[x_parent] = y_parent;
            }
        }

        int answer = 0;
        for (int i = 0; i < w.size()-1; i++) {
            answer += w.get(i);
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new int[M][3];

        int x;
        int y;
        int cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges[i][0] = x - 1;
            edges[i][1] = y - 1;
            edges[i][2] = cost;
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
