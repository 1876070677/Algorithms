import java.util.*;
import java.io.*;
public class Main {
    static Stack<String> st = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().strip().split("");
        String[] target = bf.readLine().strip().split("");
        for (int i = 0; i < s.length; i++) {
            st.push(s[i]);
            if (st.size() >= target.length) {
                int chk = 1;
                for (int j = target.length - 1; j >= 0; j--) {
                    if (!st.get(st.size() - 1 - (target.length-1-j)).equals(target[j])) {
                        chk = 0;
                        break;
                    }
                }
                if (chk == 1) {
                    for (int j = 0; j < target.length; j++)
                        st.pop();
                }
            }
        }

        if (st.isEmpty())
            System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.size(); i++)
                sb.append(st.get(i));
            System.out.println(sb);
        }
    }
}
