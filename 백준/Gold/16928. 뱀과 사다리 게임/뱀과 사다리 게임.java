import java.util.*;
import java.io.*;
public class Main {
//    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    static Queue<int []> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] maps = new int[100];
        Arrays.fill(maps, 0);
        for (int i = 0; i < N + M; i++) {
            String[] temp = bf.readLine().split(" ");
            int loc = Integer.parseInt(temp[0]);
            int target = Integer.parseInt(temp[1]);
            maps[loc-1] = target-1;
        }
        int[] start = {0, 0};
        q.add(start);

        int[] visited = new int[100];
        Arrays.fill(visited, -1);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == 99) {
                visited[curr[0]] = curr[1];
                break;
            }
            else if (visited[curr[0]] != -1)
                continue;
            visited[curr[0]] = curr[1];
            for (int i = 6; i > 0; i--) {
                if (curr[0] + i < 100) {
                    int target = curr[0] + i;
                    if (maps[curr[0] + i] > 0) {
                        target = maps[curr[0] + i];
                    }
                    int[] temp = {target, visited[curr[0]] + 1};
                    q.add(temp);
                }
            }
        }
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(visited[i*10+j]+ " ");
//            }
//            System.out.println();
//        }
        System.out.println(visited[99]);
    }
}
