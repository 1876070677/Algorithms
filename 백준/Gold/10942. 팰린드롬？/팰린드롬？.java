import java.io.*;
import java.util.*;

// 20366
public class Main {

    int N;
    int[] numbers;
    int M;

    int[][] dp;

    public int solve(int S, int E) {
        if (dp[S][E] != -1) return dp[S][E]; // 이미 DP에 존재하면 그대로 반환.

        int flag = -1;
        if (numbers[S] != numbers[E]) flag = 0; // DP에 없으면 연산 시작. 근데 양 끝 다르면 무조건 false
        else {
            flag = 1;
            if (S + 1 <= E - 1)
                flag = solve(S + 1, E - 1);
        }
        dp[S][E] = flag;
        return flag;
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        dp = new int[N][N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1; // i~i 한 글자는 무조건 팰린드롬.
        }

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int result = solve(S - 1, E - 1);
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    public void solution() throws IOException {
        input();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}