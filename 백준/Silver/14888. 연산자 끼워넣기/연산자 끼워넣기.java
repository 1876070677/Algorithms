import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static ArrayList<Integer> select = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();
    static void dfs(int depth, int[] op, int[] arrays) {
        if (depth == arrays.length-1) {
            int sum = arrays[0];
            for (int i = 1; i < arrays.length; i++) {
                if (select.get(i-1) == 0)
                    sum += arrays[i];
                else if (select.get(i-1) == 1)
                    sum -= arrays[i];
                else if (select.get(i-1) == 2)
                    sum *= arrays[i];
                else {
                    if (sum < 0) {
                        int temp = Math.abs(sum);
                        temp = (int) temp / arrays[i];
                        sum = -1 * temp;
                    } else {
                        sum = (int) sum / arrays[i];
                    }
                }
            }
            answers.add(sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if (op[i] > 0) {
                    op[i] -= 1;
                    select.add(i);
                    dfs(depth + 1, op, arrays);
                    op[i] += 1;
                    select.remove(select.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrays = new int[N];
        for (int i = 0; i < N; i++)
            arrays[i] = sc.nextInt();

        // + - x /
        int[] op = new int[4];
        for (int i = 0; i < 4; i++)
            op[i] = sc.nextInt();
        dfs(0, op, arrays);
        Collections.sort(answers);
        System.out.println(answers.get(answers.size()-1));
        System.out.println(answers.get(0));
    }
}
