import java.util.*;
class Solution {
    ArrayList<Integer> comb = new ArrayList<>();
    int answer = 0;
    int t;
    public void dfs(int depth, int[] numbers) {
        if (depth == numbers.length) {
            int sum = 0;
            for (int i = 0; i < comb.size(); i++)
                sum += comb.get(i);
            if (sum == t)
                answer += 1;
        } else {
            comb.add(numbers[depth]);
            dfs(depth+1, numbers);
            comb.remove(comb.size()-1);
            
            comb.add(-1 * numbers[depth]);
            dfs(depth+1, numbers);
            comb.remove(comb.size()-1);
        }
    }
    public int solution(int[] numbers, int target) {
        t = target;
        dfs(0, numbers);
        return answer;
    }
}