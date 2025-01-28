import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        String[] sArray = bf.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(sArray[i]);

        int lPoint = 0;
        int rPoint = 0;
        int count = 0;
        int answer = 1 - 1;
        if (array[0] % 2 == 1)
            count += 1;
        while (rPoint < N) {
//            System.out.println(lPoint + " " + rPoint);
            if (count > K) {
                if (array[lPoint] % 2 == 1)
                    count -= 1;
                lPoint += 1;
            } else {
//                System.out.println(lPoint + " " + rPoint);
                answer = Math.max(answer, (rPoint - lPoint + 1) - count);
                rPoint += 1;
                if (rPoint < N && array[rPoint] % 2 == 1)
                    count += 1;
            }
        }
        System.out.println(answer);
    }
}
