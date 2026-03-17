import java.io.*;
import java.util.*;

public class Main {
    int N;
    int total;

    boolean[][] bag;
    int[][] coins;

    public boolean solve() {
        // 1번째 동전은 그냥 초기화를 해 두는 데 사용.
        int firstCoin = coins[0][0];

        if (firstCoin <= total / 2) {
            for (int i = 0; i <= coins[0][1]; i++) {
                int result = firstCoin * i;
                if (result > total / 2) break;
                bag[0][result] = true;
            }

        }

        for (int i = 1; i < N; i++) {
            int coin = coins[i][0];
            int cnt = coins[i][1];

            if (coin > total / 2)  continue;

            for (int j = cnt; j > -1; j--) {
                int value = coin * j;
                if (value > total / 2) continue;
                bag[i][value] = true;

                for (int k = total / 2; k > -1; k--) {
                    if (k - value >= 0 && (bag[i - 1][k - value] || bag[i][k - value])) {
                        bag[i][k] = true;
                    }
                }
            }
        }

        return bag[N - 1][total / 2];
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int loopCnt = 0; loopCnt < 3; loopCnt++) {
            // init.
            total = 0;

            // cycle 1.
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            coins = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                coins[i][0] = key;
                coins[i][1] = value;
                total += (key * value);
            }

            if (total % 2 == 0) {
                bag = new boolean[N][total / 2 + 1];
                for (int i = 0; i < N; i++)
                    Arrays.fill(bag[i], false);
                if (solve()) sb.append("1\n");
                else sb.append("0\n");
            }
            else
                sb.append("0\n");
        }

        // 정답 출력.
        System.out.println(sb);
    }

    public void solution() throws IOException {
        input();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}