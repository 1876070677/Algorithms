class Solution {
    public String solution(String rny_string) {
        String answer = "";
        for (String i : rny_string.split("")) {
            if (i.equals("m")) {
                answer += 'r';
                answer += 'n';
            } else {
                answer += i;
            }
        }
        return answer;
    }
}