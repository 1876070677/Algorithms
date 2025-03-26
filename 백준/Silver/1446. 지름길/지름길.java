import java.util.*;
import java.io.*;
public class Main {
    int N, D;
    int[][] shortCut;

    public void solve() {
        int[] dist = new int[D + 1];
        Arrays.fill(dist, 10001);

        dist[0] = 0;
        for (int i = 1; i < D + 1; i++) {
            for (int j = 0; j < N; j++) {
                if (shortCut[j][1] == i)
                    dist[i] = Math.min(dist[i], dist[shortCut[j][0]] + shortCut[j][2]);
            }
            dist[i] = Math.min(dist[i], dist[i - 1] + 1);
        }

        System.out.println(dist[D]);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortCut = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shortCut[i][0] = x;
            shortCut[i][1] = y;
            shortCut[i][2] = dist;
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
