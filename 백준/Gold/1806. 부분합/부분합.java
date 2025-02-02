import java.util.*;
import java.io.*;
public class Main {

    int N;
    int S;
    int[] array;
    int answer;

    public void solve() {
        int lPoint = 0;
        int rPoint = 0;
        answer = 100001;
        int currSum = array[0];

        while (rPoint < N) {
            if (currSum >= S) {
                answer = Math.min(answer, rPoint-lPoint+1);
            }

            if (currSum <= S) {
                rPoint += 1;
                if (rPoint >= N)
                    break;
                currSum += array[rPoint];
            }
            else {
                currSum -= array[lPoint];
                lPoint += 1;
            }
        }
        if (answer == 100001)
            System.out.println(0);
        else
            System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(st.nextToken());
    }
    public void solution() throws IOException {
        input();
        solve();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
