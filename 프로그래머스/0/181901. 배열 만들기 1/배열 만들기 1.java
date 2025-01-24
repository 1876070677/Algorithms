import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (i % k == 0) {
                newList.add(i);
            }
        }
        int[] answer = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer[i] = newList.get(i);
        return answer;
    }
}