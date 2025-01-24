import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = n; i < num_list.length; i++)
            newList.add(num_list[i]);
        for (int i = 0; i < n; i++)
            newList.add(num_list[i]);
        int[] answer = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer[i] = newList.get(i);
        return answer;
    }
}