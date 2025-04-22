import java.util.*;

class Solution {
    Stack<Integer> st;
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ret = new ArrayList<>();
        st = new Stack<>();
        
        int cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            
            int days = (int) remain / speed;
            int plus = remain % speed > 0 ? 1 : 0;
            days += plus;
            
            if (st.isEmpty()) {
                st.push(days);
                cnt++;
            } else if (st.peek() < days) {
                ret.add(cnt);
                cnt = 1;
                st.push(days);
            } else {
                cnt++;
            }
        }
        ret.add(cnt);
        
        answer = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        return answer;
    }
}