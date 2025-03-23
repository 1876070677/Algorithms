import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    int N;
    int K;
    int P;
    int X;
    int answer;
    int[][] matrix;
    int[][] number;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }

    public int compare(int[] array1, int[] array2) {
        int cnt = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                cnt++;
        }
        return cnt;
    }
    public void makeMatrix() {
        matrix = new int[10][10];

        number = new int[][] {
                {1, 1, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1}
        };
        for (int i = 0; i < 10; i++)
            Arrays.fill(matrix[i], -1);
        for (int i = 0; i < 10; i++) {
            matrix[i][i] = 0;
            for (int j = i+1; j < 10; j++) {
                int diff = compare(number[i], number[j]);
                matrix[i][j] = diff;
                matrix[j][i] = diff;
            }
        }
    }

    public void dfs(int depth, int rCnt, String target, String str) {
        if (depth == K && rCnt <= P) {
            // 이건 만들 수 있는 수
            if (!target.equals(str) && Integer.parseInt(str) <= N && Integer.parseInt(str) > 0) {
                answer++;
            }
        } else if (depth == K) {
            return;
        } else {
            int currNum = Integer.parseInt(target.substring(depth, depth+1));
            for (int i = 0; i < 10; i++) {
                if (matrix[currNum][i] != -1) {
                    dfs(depth + 1, rCnt + matrix[currNum][i], target, str + i);
                }

            }
        }
    }
    public void solution() throws IOException{
        answer = 0;
        makeMatrix();
        // 자릿수 위치, 반전 갯수
        String realX = "";
        if ((""+X).length() < K) {
            int iter = K - ("" + X).length();
            for (int i = 0; i < iter; i++) {
                realX += "0";
            }
            realX += X;
        } else {
            realX = "" + X;
        }
        dfs(0, 0, realX, "");
        System.out.println(answer);
    }
    public void solve() throws IOException{
        input();
        solution();
    }

    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}
