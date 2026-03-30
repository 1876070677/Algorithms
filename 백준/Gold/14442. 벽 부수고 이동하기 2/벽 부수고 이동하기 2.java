import java.io.*;
import java.util.*;

class Cell {
    int x;
    int y;
    int dist;
    int walls;

    public Cell(int x, int y, int dist, int walls) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.walls = walls;
    }
}

public class Main {

    static int LIMIT_DIST = 1000001;

    int N;
    int M;
    int K;

    int[][] map;
    int[][][] visited;
    Queue<Cell> q = new LinkedList<>();

    int[] dx = new int[]{ -1, 0, 1, 0 };
    int[] dy = new int[]{ 0, -1, 0, 1 };

    public boolean isValid(int x, int y) {
        if (x > -1 && y > -1 && x < N && y < M) return true;
        return false;
    }

    public int solve() {
        if (N == 1 && M == 1) return 1;

        // 방문 처리하고 queue에 추가.
        visited[0][0][0] = 1;
        q.add(new Cell(0, 0, 1, 0));

        while(!q.isEmpty()) {
            Cell current = q.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!isValid(nx, ny)) continue;

                if (map[nx][ny] == 1) {
                    // 벽을 하나 더 부숴야 하기 때문에 walls + 1을 체킹.
                    if (current.walls < K && visited[nx][ny][current.walls + 1] == LIMIT_DIST) {
                        visited[nx][ny][current.walls + 1] = current.dist + 1;
                        q.add(new Cell(nx, ny, current.dist + 1, current.walls + 1));
                    }
                }
                else {
                    if (visited[nx][ny][current.walls] == LIMIT_DIST) {
                        visited[nx][ny][current.walls] = current.dist + 1;
                        q.add(new Cell(nx, ny, current.dist + 1, current.walls));
                    }
                }
            }
        }

        int result = LIMIT_DIST;
        for (int i = 0; i < K + 1; i++) {
            if (visited[N - 1][M - 1][i] != LIMIT_DIST) {
                result = Math.min(result, visited[N - 1][M - 1][i]);
            }
        }

        if (result == LIMIT_DIST) return -1;
        return result;
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][K + 1]; // 안부시는 경우를 포함해서 +1.

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();

            for (int j = 0; j < M; j++) {
                Arrays.fill(visited[i][j], LIMIT_DIST);
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
    }

    public void solution() throws IOException {
        input();
        int result = solve();
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}