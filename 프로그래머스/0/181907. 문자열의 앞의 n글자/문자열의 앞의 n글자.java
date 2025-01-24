class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int cnt = 0;
        for (String i: my_string.split("")) {
            answer += i;
            cnt += 1;
            if (cnt == n)
                break;
        }
        return answer;
    }
}