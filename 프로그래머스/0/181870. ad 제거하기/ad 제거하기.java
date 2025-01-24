import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        ArrayList<String> newList = new ArrayList<>();
        for (String i: strArr) {
            if (!i.contains("ad"))
                newList.add(i);
        }
        
        answer = new String[newList.size()];
        for (int i = 0; i < newList.size(); i++) {
            answer[i] = newList.get(i);
        }
        return answer;
    }
}