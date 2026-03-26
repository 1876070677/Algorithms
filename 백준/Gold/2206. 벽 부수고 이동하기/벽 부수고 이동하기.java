import java.io.*;
import java.util.*;

class Cell {
    int x;
    int y;
    int dist;
    boolean isBreak;

    public Cell(int x, int y, int dist, boolean isBreak) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.isBreak = isBreak;
    }
}

public class Main {

    int N;
    int M;

    int[][] map;
    int[][] visitedWOBreak;
    int[][] visitedWBreak;
    Queue<Cell> q = new LinkedList<>();

    int[] dx = new int[]{ -1, 0, 1, 0 };
    int[] dy = new int[]{ 0, -1, 0, 1 };

    public boolean isValid(int x, int y) {
        if (x > -1 && y > -1 && x < N && y < M) return true;
        return false;
    }

    public int solve() {
        if (N == 1 && M == 1) return 1;
        q.add(new Cell(0, 0, 0, false));

        while(!q.isEmpty()) {
            Cell current = q.poll();
            int cx = current.x;
            int cy = current.y;

            if (current.isBreak) {
                if (visitedWBreak[cx][cy] > 0) continue;
                visitedWBreak[cx][cy] = current.dist;
            }
            else {
                if (visitedWOBreak[cx][cy] > 0) continue;
                visitedWOBreak[cx][cy] = current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!isValid(nx, ny)) continue;

                if (map[nx][ny] == 1) {
                    if (!current.isBreak) {
                        q.add(new Cell(nx, ny, current.dist + 1, true));
                    }
                }
                else {
                    q.add(new Cell(nx, ny, current.dist + 1, current.isBreak));
                }
            }
        }

        int distWBreak = visitedWBreak[N - 1][M - 1];
        int distWOBreak = visitedWOBreak[N - 1][M - 1];

        if (distWBreak == 0 && distWOBreak == 0) return -1;
        if (distWBreak == 0) return distWOBreak + 1;
        if (distWOBreak == 0) return distWBreak + 1;
        return Math.min(distWBreak, distWOBreak) + 1;
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visitedWOBreak = new int[N][M];
        visitedWBreak = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visitedWBreak[i], 0);
            Arrays.fill(visitedWOBreak[i], 0);
            st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();

            for (int j = 0; j < M; j++) {
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