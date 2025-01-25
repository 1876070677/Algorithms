import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int current = 0;
        ArrayList<Long> diff = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            if (A > B)
                current += 1;
            else
                diff.add(B - A);
        }
        Collections.sort(diff);
        long answer = 0;
        if (current >= K)
            answer = 0;
        else {
            answer = diff.get(K-current-1);
        }
        System.out.println(answer);
    }
}
