import java.io.*;
import java.util.*;

public class Main {

    int B;
    String[] highB;
    String[] lowB;

    int N;

    public int cmp(String data, String pattern) {
        int matchCount = 0;
        int patternSize = pattern.length();
        long bitmask = 0L;
        long mask = (1L << patternSize) - 1; // 패턴 사이즈만큼만 1로 채워져있음.

        int i;
        for (i = 0; i < patternSize; i++) {
            bitmask = (bitmask << 1) | (data.charAt(i) - '0');
        }

        long patternToLong = Long.parseLong(pattern, 2);

        if (bitmask == patternToLong) matchCount++;

        for (; i < data.length(); i++) {
            bitmask = ((bitmask << 1) | (data.charAt(i) - '0')) & mask; // 패턴 사이즈만큼만 남기기 가능.
            if (bitmask == patternToLong) matchCount++;
        }

        return matchCount;
    }

    public int cmpPatterns(String data) {
        int lowPatternMatchCnt = 0;
        int highPatternMatchCnt = 0;

        for (int i = 0; i < B; i++) {
            lowPatternMatchCnt += cmp(data, lowB[i]);
        }

        for (int i = 0; i < B; i++) {
            highPatternMatchCnt += cmp(data, highB[i]);
        }

        return highPatternMatchCnt - lowPatternMatchCnt; // C (현재 차고)
    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        B = Integer.parseInt(st.nextToken());

        // init.
        highB = new String[B];
        lowB = new String[B];

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(bf.readLine());
            lowB[i] = st.nextToken(); // 2진수로 파싱.
        }

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(bf.readLine());
            highB[i] = st.nextToken();
        }

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String realTimeData = st.nextToken();

            int answer = cmpPatterns(realTimeData);

            if (0 > answer) {
                System.out.println("HIGH " + Math.abs(answer));
            }
            else if (0 < answer) {
                System.out.println("LOW " + Math.abs(answer));
            }
            else {
                System.out.println("GOOD");
            }
        }
    }

    public void solution() throws IOException {
        input();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}