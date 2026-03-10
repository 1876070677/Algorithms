import java.io.*;
import java.util.*;

public class Main {
    static int MAX_WEIGHT = 1000000 * 300;

    int N;
    int M;
    int S;
    int T;

    int[][] dp;

    int Q;

    // TODO: 출력용 func.
    public void printGraph(int[][] g) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dp() {
        for (int i = 0; i < N; i++) {
            // i: 경유지
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // j: source.
                    // k: target.
                    if (j == k) continue;
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
    }

    public int calcNewDp(int a1, int b1, int c1, int a2, int b2, int c2) {
        int result = dp[S - 1][T - 1];
        int a1b1 = Math.min(dp[a1 - 1][b1 - 1], c1);
        int a2b2 = Math.min(dp[a2 - 1][b2 - 1], c2);

        // case 1. S -> a1 -> b1 -> T.
        result = Math.min(result, dp[S - 1][a1 - 1] + a1b1 + dp[b1 - 1][T - 1]);

        // case 2. S -> a2 -> b2 -> T.
        result = Math.min(result, dp[S - 1][a2 - 1] + a2b2 + dp[b2 - 1][T - 1]);

        // case 3. S -> a1 -> b1 -> a2 -> b2 -> T.
        result = Math.min(result, dp[S - 1][a1 - 1] + a1b1 + dp[b1 - 1][a2 - 1] + a2b2 + dp[b2 - 1][T - 1]);

        // case 4. S -> a2 -> b2 -> a1 -> b1 -> T.
        result = Math.min(result, dp[S - 1][a2 - 1] + a2b2 + dp[b2 - 1][a1 - 1] + a1b1 + dp[b1 - 1][T - 1]);

        if (MAX_WEIGHT + 1 <= result) return -1;
        return result;
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // init graph.
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], MAX_WEIGHT + 1); // W의 최대값 + 1 (방어 목적).
            dp[i][i] = 0; // 자기 자신으로 가는 거리는 0.
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[u - 1][v - 1] = Math.min(dp[u - 1][v - 1], w);
        }

        // make dp. 플로이드 워셜.
        dp();

        st = new StringTokenizer(bf.readLine());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int result = calcNewDp(a1, b1, c1, a2, b2, c2);
            System.out.println(result); // 정답 출력.
        }
        // printGraph(dp); // TODO: 출력용.
        // System.out.print(dp[S - 1][T - 1]); // TODO: DP 검증용.
    }

    public void solution() throws IOException {
        input();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}