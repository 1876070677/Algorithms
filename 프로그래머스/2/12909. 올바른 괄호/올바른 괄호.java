import java.util.*;

class Solution {
    Stack<Character> st;
    
    boolean solution(String s) {
        boolean answer = true;
        st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(') {
                st.push(t);
            } else {
                if (st.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    st.pop();
                }
            }
        }
        
        if (!st.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}