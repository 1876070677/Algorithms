import java.io.*;
import java.util.*;

// 20366
public class Main {

    int N;
    int[] snows;

    int answer = 2000000001;

    public void makeSnowMan(int a, int b) {
        int baseHeight = snows[a] + snows[b];

        int i = 0;
        int j = N - 1;

        while (i < j) {
            while (i == a || i == b) i++;
            while (j == a || j == b) j--;

            if (j <= i) break;

            int height = snows[i] + snows[j];
            int diff = baseHeight - height;
            answer = Math.min(answer, Math.abs(diff));

            if (diff < 0) j--;
            else if (diff > 0) i++;
            else break;
        }
    }

    public void solve() {
        // snows 정렬.
        Arrays.sort(snows);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                makeSnowMan(i, j);
            }
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        snows = new int[N];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            snows[i] = Integer.parseInt(st.nextToken());
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