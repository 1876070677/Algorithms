import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    int N;
    int[] array;
    int[] dp;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        array = new int[N];
        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(bf.readLine());
    }

    public void solution() throws IOException{
        dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    if (dp[i] < dp[j] + 1)
                        dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(N - max);
    }
    public void solve() throws IOException{
        input();
        solution();
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
