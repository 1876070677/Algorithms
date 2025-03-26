import java.util.*;
import java.io.*;
public class Main {
    int N;
    int[] buildings;

    public void solve() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int x1 = i + 1;
            int h1 = buildings[i];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                // 빌딩 i에서 j를 볼 수 있는가?
                int x2 = j + 1;
                int h2 = buildings[j];
                int check = 1;

                if (j < i) {
                    for (int k = j + 1; k < i; k++) {
                        int x3 = k + 1;
                        int h3 = buildings[k];

                        double y = ((double) (h1 - h2) / (double) (x1 - x2)) * (x3 - x2) + h2;

                        if (h3 >= y) {
                            check = 0;
                        }
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        int x3 = k + 1;
                        int h3 = buildings[k];

                        double y = ((double) (h2 - h1) / (double) (x2 - x1)) * (x3 - x1) + h1;

                        if (h3 >= y) {
                            check = 0;
                        }
                    }
                }

                if (check == 1) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        buildings = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
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
