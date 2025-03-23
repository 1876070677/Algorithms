import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    int N;
    int[][] array;
    int[] visited;
    int[] cycle;
    int answer_size;
    ArrayList<Integer> answer;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        array = new int[N][2];
        for (int i = 0; i < N; i++) {
            array[i][0] = i;
            array[i][1] = Integer.parseInt(bf.readLine()) - 1;
        }
    }

    public void dfs(int start_point, int curr, ArrayList<Integer> selected) {
        if (visited[curr] == 1 && start_point == curr) {
            answer_size += selected.size();
            answer.addAll(selected);
            for (int i = 0; i < selected.size(); i++) {
                cycle[selected.get(i)] = 1;
            }
        } else if (visited[curr] == 0) {
            visited[curr] = 1;
            selected.add(curr);
            dfs(start_point, array[curr][1], selected);
            selected.remove(selected.size() - 1);
            visited[curr] = 0;
        }
    }

    public void solution() throws IOException{
        visited = new int[N];
        cycle = new int[N];
        Arrays.fill(cycle, 0);
        answer_size = 0;
        answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (cycle[i] == 0) {
                Arrays.fill(visited, 0);
                ArrayList<Integer> selected = new ArrayList<>();
                dfs(i, i, selected);
            }
        }

        System.out.println(answer_size);
        Collections.sort(answer, ((o1, o2) -> {
            return o1 - o2;
        }));
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i) + 1);
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
