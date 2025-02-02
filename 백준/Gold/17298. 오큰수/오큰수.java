import java.util.*;
import java.io.*;
public class Main {

    int N;
    int[] array;
    int[] answer;
    Stack<int[]> stack;
    public void solve() {
        stack = new Stack<>();
        answer = new int[N];
        Arrays.fill(answer, -1);
        // 값, 인덱스
        stack.push(new int[] {array[0], 0});

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= stack.peek()[0])
                stack.push(new int[] {array[i], i});
            else {
                for (int j = stack.size()-1; j >= 0; j--) {
                    if (array[i] > stack.peek()[0]) {
                        int[] curr = stack.pop();
                        answer[curr[1]] = array[i];
                    } else {
                        break;
                    }
                }
                stack.push(new int[] {array[i], i});
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
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
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
