import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] edges = new int[N*2][2];
        for (int i = 0; i < N*2; i++) {
            String[] s = bf.readLine().split(" ");
            edges[i][0] = Integer.parseInt(s[0]);
            edges[i][1] = 1;
            edges[i+1][0] = Integer.parseInt(s[1]);
            edges[i+1][1] = -1;
            i++;
        }

        Arrays.sort(edges, ((o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        }));

        //Arrays.stream(edges).forEach(item -> {System.out.println(item[0] + " " + item[1]);});
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < edges.length; i++) {
            count += edges[i][1];
            maxCount = Math.max(count, maxCount);
        }
        System.out.println(maxCount);
    }
}
