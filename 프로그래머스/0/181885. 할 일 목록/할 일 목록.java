import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i])
                newList.add(todo_list[i]);
        }
        String[] answer = new String[newList.size()];
        for (int i = 0; i < newList.size(); i++) {
            answer[i] = newList.get(i);
        }
        return answer;
    }
}