import java.util.*;
import java.io.*;
public class Main {

    private int N;
    private int[] liquids;
    private int diff = 2000000001;
    private int[] answer;

    public void solve() {
        answer = new int[2];
        boolean chk = false;
        //Arrays.sort(liquids);
        for (int i = 0; i < N-1; i++) {
            int lPoint = i + 1;
            int rPoint = liquids.length -1;
            while (lPoint < rPoint) {
                int number = (lPoint + rPoint) / 2;
                if (diff > Math.abs(0 - (liquids[i] + liquids[number]))) {
                    diff = Math.abs(0 - (liquids[i] + liquids[number]));
                    answer[0] = Math.min(i, number);
                    answer[1] = Math.max(i, number);
                }
                if (liquids[i] + liquids[number] > 0)
                    rPoint = number - 1;
                if (liquids[i] + liquids[number] < 0)
                    lPoint = number + 1;
                if (liquids[i] + liquids[number] == 0){
                    chk = true;
                    break;
                }
            }
            if (chk)
                break;
            else {
                if (diff > Math.abs(0 - (liquids[i] + liquids[lPoint]))) {
                    diff = Math.abs(0 - (liquids[i] + liquids[lPoint]));
                    answer[0] = Math.min(i, lPoint);
                    answer[1] = Math.max(i, lPoint);
                }
            }
        }
        System.out.println(liquids[answer[0]] + " " + liquids[answer[1]]);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            liquids[i] = Integer.parseInt(st.nextToken());
    }
    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
