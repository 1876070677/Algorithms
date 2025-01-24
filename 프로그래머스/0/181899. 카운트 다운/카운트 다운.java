import java.util.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = start_num; i > end_num - 1; i--)
            newList.add(i);
        int[] answer = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer[i] = newList.get(i);
        return answer;
    }
}