import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static boolean isInTheMap(int x, int y, int limitX, int limitY) {
        if (x > -1 && x < limitX && y > -1 && y < limitY)
            return true;
        return false;
    }
    static int dfs(int x, int y, int[][] maps, int[][] visited) {
        if (x == maps.length - 1 && y == maps[0].length - 1) {
            return 1;
        } else if (visited[x][y] != -1) {
            return visited[x][y];
        }else {
            visited[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInTheMap(nx, ny, maps.length, maps[0].length) && maps[x][y] > maps[nx][ny]) {
                    visited[x][y] = visited[x][y] + dfs(nx, ny, maps, visited);
                }
            }
        }
        return visited[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] maps = new int[M][N];
        int[][] visited = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
                visited[i][j] = -1;
            }
        answer = dfs(0, 0, maps, visited);
        System.out.println(answer);
    }
}
