import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            newList.add(my_string.substring(i));
        }
        Collections.sort(newList);
        String[] answer = new String[newList.size()];
        for (int i = 0; i < newList.size(); i++)
            answer[i] = newList.get(i);
        return answer;
    }
}