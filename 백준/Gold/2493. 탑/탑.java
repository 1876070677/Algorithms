import java.util.*;
import java.io.*;
public class Main {
    private int N;
    private int[] tops;
    private Stack<int[]> stack;
    private int[] answer;

    public void solve() {
        answer = new int[N];
        stack = new Stack<>();

        stack.push(new int[] {tops[tops.length - 1], tops.length - 1});
        for (int i = tops.length-2; i >= 0; i--) {
            if (stack.peek()[0] > tops[i])
                stack.push(new int[] {tops[i], i});
            else {
                int cnt = 0;
                for (int j = stack.size() - 1; j >= 0; j--) {
                    if (stack.get(j)[0] > tops[i])
                        break;
                    else {
                        answer[stack.get(j)[1]] = i + 1;
                        cnt++;
                    }
                }
                for (int j = 0; j < cnt; j++)
                    stack.pop();
                stack.push(new int[] {tops[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++)
            sb.append(answer[i] + " ");
        System.out.println(sb);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tops = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
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
