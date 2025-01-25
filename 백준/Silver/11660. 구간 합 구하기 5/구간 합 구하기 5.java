import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        int[][] sums = new int[N][N];
        // 가로 첫 번째 행 완성, 세로 첫 번째 열 완성
        int tempSum1 = 0;
        int tempSum2 = 0;
        for (int i = 0; i < N; i++) {
            sums[0][i] = tempSum1 + maps[0][i];
            tempSum1 += maps[0][i];

            sums[i][0] = tempSum2 + maps[i][0];
            tempSum2 += maps[i][0];
        }
        // 중간 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] + maps[i][j] - sums[i-1][j-1];
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++)
//                System.out.print(sums[i][j]);
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;

            int leftSquare = 0;
            if (y1 > 0)
                leftSquare = sums[x2][y1-1];

            int upSquare = 0;
            if (x1 > 0)
                upSquare = sums[x1-1][y2];

            int duplicated = 0;
            if (x1 > 0 && y1 > 0)
                duplicated = sums[x1-1][y1-1];
            int answer = sums[x2][y2] - leftSquare - upSquare + duplicated;

            System.out.println(answer);
        }
    }
}
