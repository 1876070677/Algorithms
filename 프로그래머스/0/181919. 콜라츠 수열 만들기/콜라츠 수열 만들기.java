import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> newList = new ArrayList<>();
        while (n > 1) {
            newList.add(n);
            if (n % 2 == 0)
                n /= 2;
            else
                n = (3*n) + 1;
        }
        newList.add(1);
        int[] answer = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer[i] = newList.get(i);
        return answer;
    }
}