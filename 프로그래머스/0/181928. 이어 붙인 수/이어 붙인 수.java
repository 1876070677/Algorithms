class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String od = "";
        String ev = "";
        for (int num: num_list) {
            if (num % 2 == 1)
                od = od + Integer.toString(num);
            else
                ev = ev + Integer.toString(num);
        }
        answer = Integer.parseInt(od) + Integer.parseInt(ev);
        return answer;
    }
}