import java.io.*;
import java.util.*;

// 20366
public class Main {

    int n;
    int k;
    int[] coins;

    int[][] dp;

    public void printDP() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solve() {
        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 0);

        // fisrt coin 처리.
        int firstCoin = coins[0];
        int cnt = 1;
        while (firstCoin * cnt <= k) {
            dp[0][firstCoin * cnt] = 1;
            cnt++;
        }
        dp[0][0] = 1;

        // printDP();

        // 이제 두 번째부터 처리.
        for (int i = 1; i < n; i++) {
            int coin = coins[i];
            int idx = 1;

            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            while (coin * idx <= k) {
                int value = coin * idx;

                for (int j = 1; j <= k; j++) {
                    // i-1개로 k를 만드는 경우의 수 + i개로 k를 만드는 경우의 수.
                    int current = 0;
                    if (j - value >= 0) {
                        current = dp[i - 1][j - value];
                    }
                    dp[i][j] += current;
                }
                idx++;
            }
            // printDP();
        }

        System.out.println(dp[n - 1][k]);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
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