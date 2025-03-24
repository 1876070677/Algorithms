import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    int T;
    String[] inputs;
    int[] K;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        inputs = new String[T];
        K = new int[T];
        for (int i = 0; i < T; i++) {
            inputs[i] = bf.readLine().strip();
            K[i] = Integer.parseInt(bf.readLine());
        }
    }

    public void solution() throws IOException{
        HashMap<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < T; i++) {
            if (K[i] == 1) {
                System.out.println("1 1");
                continue;
            }
            set.clear();
            int answer_min = 10001;
            int answer_max = 0;
            for (int j = 0; j < inputs[i].length(); j++) {
                if (!set.containsKey(inputs[i].charAt(j)))
                    set.put(inputs[i].charAt(j), 1);
                else {
                    int temp = set.get(inputs[i].charAt(j)) + 1;
                    set.put(inputs[i].charAt(j), temp);
                }
            }

            for (int j = 0; j < inputs[i].length(); j++) {
                if (set.get(inputs[i].charAt(j)) >= K[i]) {
                    int cnt = 1;
                    for (int k = j + 1; k < inputs[i].length(); k++) {
                        if (inputs[i].charAt(k) == inputs[i].charAt(j)) {
                            cnt++;
                        }

                        if (cnt == K[i]) {
                            int length = (k - j) + 1;
                            answer_min = Math.min(answer_min, length);
                            answer_max = Math.max(answer_max, length);
                            break;
                        }
                    }
                }
            }
            if (answer_min == 10001 && answer_max == 0)
                System.out.println(-1);
            else
                System.out.println(answer_min + " " + answer_max);
        }
    }
    public void solve() throws IOException{
        input();
        solution();
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}