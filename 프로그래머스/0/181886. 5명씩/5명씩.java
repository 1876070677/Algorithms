import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        String[] answer = {};
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < names.length; i++)
        {
            newList.add(names[i]);
            i += 4;   
        }
        answer = newList.toArray(new String[newList.size()]);
        return answer;
    }
}