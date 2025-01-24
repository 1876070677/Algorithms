import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        ArrayList<String> list = new ArrayList<>();
        
        for (String i : answer)
            if (i.length() > 0)
                list.add(i);
        
        String[] newAnswer = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            newAnswer[i] = list.get(i);
        return newAnswer;
    }
}