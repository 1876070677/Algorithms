import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    int T;
    int[] input;
    ArrayList<Character> bucket;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        input = new int[T];
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(bf.readLine());
        }
    }

    public void dfs(int t, int depth, String op) {
        if (depth == input[t]) {
            String rop = op.replace(" ", "");
            String[] temp = rop.split("[+-]");
            ArrayList<Character> ops = new ArrayList<>();
            int sum = Integer.parseInt(temp[0]);
            for (int i = 0; i < rop.length(); i++) {
                if (rop.charAt(i) == '+' || rop.charAt(i) == '-') {
                    ops.add(rop.charAt(i));
                }
            }

            for (int i = 0; i < ops.size(); i++) {
                if (ops.get(i) == '+') {
                    sum += Integer.parseInt(temp[i + 1]);
                } else {
                    sum -= Integer.parseInt(temp[i + 1]);
                }
            }
            if (sum == 0) {
                System.out.println(op);
            }

        } else {
            op += (depth+1);

            if (depth + 1 == input[t]) {
                dfs(t, depth+1, op);
            } else {
                dfs(t, depth+1, op+" ");

                dfs(t, depth+1, op + "+");

                dfs(t, depth+1, op+"-");
            }
        }
    }

    public void solution() throws IOException{
        for (int i = 0; i < T; i++) {
            dfs(i, 0, "");
            System.out.println();
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
