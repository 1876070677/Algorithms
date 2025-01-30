import java.util.*;
import java.io.*;
public class Main {

    private int N;
    private int M;
    private int[] array;
    private int answer;

    public void solve() {
        Arrays.sort(array);
        answer = 2000000001;
        boolean chk = false;
        for (int i = 0; i < array.length - 1; i++) {
            int lPoint = i+1;
            int rPoint = array.length - 1;
            while (lPoint <= rPoint) {
                int number = (lPoint + rPoint) / 2;
                int diff = Math.abs(array[i] - array[number]);
                if (diff >= M) {
                    answer = Math.min(answer, diff);
                }
                if (diff < M)
                    lPoint = number + 1;
                if (diff > M)
                    rPoint = number - 1;
                if (diff == M) {
                    chk = true;
                    break;
                }
            }
            if (chk)
                break;
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
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
