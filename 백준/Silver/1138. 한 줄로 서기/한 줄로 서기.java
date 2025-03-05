import java.io.*;
import java.util.*;
public class Main {

    int N;
    int[] array;
    int[] visited;

    Stack<Integer> st = new Stack<>();
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public boolean validate(int num, int cnt) {
        int tmp_cnt = 0;
        for (int i = st.size() - 1; i > -1; i--) {
            if (st.get(i) > num)
                tmp_cnt++;
        }
        if (cnt == tmp_cnt)
            return true;
        return false;
    }

    public void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < st.size(); i++) {
                System.out.print((st.get(i)+1) + " ");
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    if (validate(i, array[i])) {
                        visited[i] = 1;
                        st.push(i);
                        dfs(depth + 1);
                        st.pop();
                        visited[i] = 0;
                    }
                }
            }
        }
    }

    public void solution() throws IOException{
        visited = new int[N];
        Arrays.fill(visited, 0);
        dfs(0);
    }
    public void solve() throws IOException{
        input();
        solution();
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
