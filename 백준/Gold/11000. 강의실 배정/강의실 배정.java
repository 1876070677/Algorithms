import java.util.*;
import java.io.*;
public class Main {
    private int N;
    private int[][] lectures;
    private int answer;

    public void solve() {
        int count = 0;
        answer = 0;
        Arrays.sort(lectures, (((o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        })));

        for (int i = 0; i < 2*N; i++) {
            count += lectures[i][1];
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lectures = new int[2*N][2];
        for (int i = 0; i < N*2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i][0] = start;
            lectures[i][1] = 1;
            lectures[i+1][0] = end;
            lectures[i+1][1] = -1;
            i++;
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
