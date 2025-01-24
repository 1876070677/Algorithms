class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for (String i : num_str.split(""))
            answer += Integer.parseInt(i);
        return answer;
    }
}