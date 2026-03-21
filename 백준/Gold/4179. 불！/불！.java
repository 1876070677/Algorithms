import java.io.*;
import java.util.*;

public class Main {
    int R;
    int C;

    String[][] map;
    int[][] fireMap;
    int[][] jiHoonMap;

    Queue<int[]> queue = new LinkedList<>();

    int[] dx = new int[]{ -1 , 0, 1, 0 };
    int[] dy = new int[]{ 0, -1, 0, 1 };

    int answer = -1;

    public void printMap(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEdge(int x, int y) {
        if (x == 0 || y == 0 || x == R - 1 || y == C - 1) return true;
        return false;
    }

    public boolean isValid(int x, int y) {
        if (x > -1 && y > -1 && x < R && y < C && !map[x][y].equals("#")) return true;
        return false;
    }

    public void fireBFS() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("F")) {
                    fireMap[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (isValid(x, y)) {
                            queue.add(new int[]{ x, y, 1 });
                        }
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int value = current[2];

            if (fireMap[cx][cy] != 1000001) continue;

            fireMap[cx][cy] = value;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny)) {
                    queue.add(new int[]{ nx, ny, value + 1 });
                }
            }
        }

        // queue.clear();
    }

    public void jiHoonBFS() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("J")) {
                    queue.add(new int[]{ i, j, 0 });
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int value = current[2];

            // 두 가지 종료 조건: 방문했거나 불이 붙어있거나.
            if (jiHoonMap[cx][cy] != 1000001 || value >= fireMap[cx][cy]) continue;
            // 가장자리 판별.
            if (isEdge(cx, cy)) {
                answer = value + 1;
                break;
            }

            jiHoonMap[cx][cy] = value;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny)) {
                    queue.add(new int[]{ nx, ny, value + 1});
                }
            }
        }

        queue.clear();
    }

    public void solve() {
        fireBFS();
        // printMap(fireMap);

        jiHoonBFS();
        // printMap(jiHoonMap);

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        fireMap = new int[R][C];
        jiHoonMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            Arrays.fill(fireMap[i], 1000001);
            Arrays.fill(jiHoonMap[i], 1000001);
            String[] tmp = st.nextToken().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp[j];
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