import java.util.*;
import java.io.*;
public class Main {
    private int N;
    private int M;
    private int[][] maps;
    private ArrayList<int[]> chickens;
    private ArrayList<int[]> houses;

    private ArrayList<int[]> comb;

    private int answer = 1400;

    public int calcDistance() {
        int dist = 0;

        for (int i = 0; i < houses.size(); i++) {
            int cx = houses.get(i)[0];
            int cy = houses.get(i)[1];

            int distMin = 101;
            for (int j = 0; j < comb.size(); j++) {
                int tx = comb.get(j)[0];
                int ty = comb.get(j)[1];
                distMin = Math.min(distMin, Math.abs(tx-cx) + Math.abs(ty-cy));
            }
            dist += distMin;
        }

        return dist;
    }

    public void dfs(int depth, int start) {
        if (depth == M) {
            // 새로운 맵을 하나 만들고 집들이랑 치킨집 거리 계산
//            for (int i = 0; i < comb.size(); i++) {
//                System.out.println(comb.get(i)[0] + " " + comb.get(i)[1]);
//            }
//            System.out.println();

            int dist = calcDistance();
            answer = Math.min(answer, dist);
        } else {
            for (int i = start; i < chickens.size(); i++) {
                comb.add(chickens.get(i));
                dfs(depth + 1, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }

    public void solve() {
        // DFS
        comb = new ArrayList<>();
        dfs(0, 0);
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                } else if (maps[i][j] == 1)
                    houses.add(new int[]{i, j});
            }
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
