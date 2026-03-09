import java.io.*;
import java.util.*;

public class Main {
    public int N;
    public String[] S;
    public Map<String, Integer> state = new HashMap<>();
    public int answer = 0;

    public int t = 0;
    public int g = 0;
    public int f = 0;
    public int p = 0;

    public int processing(int n) {
        return (n + 1) % 3;
    }

    public void solve() {
        state.put("0000", 1);

        for (int i = 0; i < N; i++) {
            if (S[i].equals("T")) t = processing(t);
            else if (S[i].equals("G")) g = processing(g);
            else if (S[i].equals("F")) f = processing(f);
            else p = processing(p);

            String key = Integer.toString(t) + Integer.toString(g) + Integer.toString(f) + Integer.toString(p);
            // Key 로깅용.
            // System.out.println(key);

            if (state.containsKey(key)) {
                answer += state.get(key);
                state.put(key, state.get(key) + 1);
            }
            else {
                state.put(key, 1);
            }
        }

        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        S = st.nextToken().split("");
    }

    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}