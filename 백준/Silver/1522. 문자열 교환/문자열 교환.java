import java.io.*;
import java.util.*;
import java.math.*;
public class Main {

    char[] array;
    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().strip();

        array = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
        }
    }

    public void solution() throws IOException{
        int answer = 501;
        int a_cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a')
                a_cnt++;
        }

        int end = 0;
        int b_cnt = 0;
        for (int i = 0; i < array.length; i++) {
            while (end < i + a_cnt) {
                if (array[end % array.length] == 'b')
                    b_cnt++;
                end++;
            }
            answer = Math.min(answer, b_cnt);
            if (array[i] == 'b')
                b_cnt--;
        }
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
