import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[][] maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    maps[i][j] = 0;
                else
                    maps[i][j] = 10000001;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]) - 1;
            int end = Integer.parseInt(s[1]) - 1;
            int cost = Integer.parseInt(s[2]);
            maps[start][end] = Math.min(maps[start][end], cost);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && maps[j][i] != 10000001) {
                    for (int k = 0; k < n; k++) {
                        if (i != k)
                            maps[j][k] = Math.min(maps[j][k], maps[j][i] + maps[i][k]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 10000001)
                    maps[i][j] = 0;
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
