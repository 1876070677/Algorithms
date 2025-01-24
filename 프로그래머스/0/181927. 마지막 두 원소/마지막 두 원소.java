import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int answer = 0;
        if (num_list[num_list.length-1] > num_list[num_list.length-2])
            answer = num_list[num_list.length-1] - num_list[num_list.length-2];
        else
            answer = num_list[num_list.length-1] * 2;
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < num_list.length; i++)
            newList.add(num_list[i]);
        newList.add(answer);
        int[] answer2 = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer2[i] = newList.get(i);
        return answer2;
    }
}