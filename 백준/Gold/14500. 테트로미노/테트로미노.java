import java.util.*;
import java.io.*;
public class Main {
    static Stack<String> st = new Stack<>();
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean isInTheMap(int x, int y, int limitX, int limitY) {
        if (x > -1 && y > -1 && x < limitX && y < limitY)
            return true;
        return false;
    }

    public static void dfs(int x, int y, int sum, int depth, int[][] visited, int[][] maps) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInTheMap(nx, ny, maps.length, maps[0].length) && visited[nx][ny] == -1) {
                    if (depth == 2) {
                        visited[nx][ny] = 1;
                        dfs(x, y, sum + maps[nx][ny], depth + 1, visited, maps);
                        visited[nx][ny] = -1;
                    }
                    visited[nx][ny] = 1;
                    dfs(nx, ny, sum + maps[nx][ny], depth + 1, visited, maps);
                    visited[nx][ny] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = bf.readLine().split(" ");
            for (int j = 0; j < M; j++)
                maps[i][j] = Integer.parseInt(temp[j]);
        }

        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                dfs(i, j, maps[i][j], 1, visited, maps);
                visited[i][j] = -1;
            }
        }

        System.out.println(answer);
    }
}
