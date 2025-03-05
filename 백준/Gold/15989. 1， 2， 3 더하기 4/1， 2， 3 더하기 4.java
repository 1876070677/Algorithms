import java.io.*;
import java.util.*;
public class Main {
    public void input() throws IOException {

    }

    public void solution() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bf.readLine());
            int cnt = 0;
            for (int j = (int) n / 3; j > -1 ; j--) {
                int mod = n - (j * 3);
                cnt += ((int) mod / 2) + 1;
            }
            System.out.println(cnt);
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
