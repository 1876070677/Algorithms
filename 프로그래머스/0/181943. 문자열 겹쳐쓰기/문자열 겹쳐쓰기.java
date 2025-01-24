class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String[] my = my_string.split("");
        String[] over = overwrite_string.split("");
        for (int i = s; i < s+ overwrite_string.length(); i++) {
            my[i] = over[i-s];
        }
        for (int i = 0; i < my.length; i++)
            answer += my[i];
        return answer;
    }
}