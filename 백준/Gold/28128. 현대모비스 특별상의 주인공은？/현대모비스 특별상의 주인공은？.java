import java.io.*;
import java.util.*;

public class Main {

    int N;
    int M;
    String[][] board;

    int[] nextX = new int[]{ -1, 0, 1, 0};
    int[] nextY = new int[]{ 0, -1 , 0, 1};

    int[] nextNextX = new int[]{-2, 0, 2, 0};
    int[] nextNextY = new int[]{0, -2, 0, 2};

    public boolean isValid(int x, int y) {
        if (-1 < x && -1 < y && x < N && y < M) return true;
        return false;
    }

    public boolean isNext(int x, int y, String value) {
        boolean check = false;

        for (int i = 0; i < nextX.length; i++) {
            int nx = x + nextX[i];
            int ny = y + nextY[i];
            if (isValid(nx, ny) && board[nx][ny].equals(value)) {
                check = true;
                break;
            }
        }

        return check;
    }

    public boolean isNextNext(int x, int y, String value) {
        boolean check = false;

        for (int i = 0; i < nextNextX.length; i++) {
            int nx = x + nextNextX[i];
            int ny = y + nextNextY[i];
            if (isValid(nx, ny) && board[nx][ny].equals(value)) {
                check = true;
                break;
            }
        }

        return check;
    }

    public void solve() {
        Set<String> answer = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean check = false;
                check = isNext(i, j, board[i][j]);
                if (check) {
                    answer.add(board[i][j]);
                    continue; // 통과되면 아래 조건 탐색 필요 X.
                }

                check = isNextNext(i, j, board[i][j]);
                if (check) answer.add(board[i][j]);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("MANIPULATED");
            return;
        }

        // Set을 리스트로 변환 후 정렬.
        List<String> sorted = new ArrayList<>(answer);
        Collections.sort(sorted);

        for (String name: sorted) {
            System.out.println(name);
        }
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = st.nextToken();
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