class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for (String i: my_string.split("")) {
            if (i.equals(alp))
                answer += i.toUpperCase();
            else
                answer += i;
        }
        return answer;
    }
}