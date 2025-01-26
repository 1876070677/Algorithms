import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer> select = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt() - 1;
        int[][] maps = new int[N][N];

        for (int i = 0; i < maps.length; i++)
            for (int j = 0; j < maps.length; j++)
                maps[i][j] = 0;

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            maps[x-1][y-1] = 1;
            maps[y-1][x-1] = 1;
        }
        int[] visited = new int[N];
        Arrays.fill(visited, 0);
        s.push(V);

        while (!s.isEmpty()) {
            int node = s.pop();

            if (visited[node] > 0)
                continue;
            visited[node] = 1;
            select.add(node + 1);
            for (int i = maps.length-1; i > -1; i--) {
                if (maps[node][i] > 0)
                    s.push(i);
            }
        }
        for (int i = 0; i < select.size(); i++)
            System.out.print(select.get(i) + " ");
        System.out.println();
        select.clear();
        Arrays.fill(visited, 0);
        q.add(V);
        while (!q.isEmpty()) {
            int node = q.poll();

            if (visited[node] > 0)
                continue;
            visited[node] = 1;
            select.add(node + 1);
            for (int i = 0; i < N; i++) {
                if (maps[node][i] > 0)
                    q.add(i);
            }
        }
        for (int i = 0; i < select.size(); i++)
            System.out.print(select.get(i) + " ");
        System.out.println();
    }
}
