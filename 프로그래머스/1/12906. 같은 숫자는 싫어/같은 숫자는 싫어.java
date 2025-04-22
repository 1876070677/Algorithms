import java.util.*;

public class Solution {
    Stack<Integer> st;
    public int[] solution(int []arr) {
        int[] answer = {};
        st = new Stack<>();
        st.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != st.peek()) {
                st.push(arr[i]);
            }
        }
        
        answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        return answer;
    }
}