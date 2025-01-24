class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        String[] s1 = str1.split("");
        String[] s2 = str2.split("");
        for (int i = 0; i < str1.length(); i++) {
            answer += s1[i];
            answer += s2[i];
        }
        return answer;
    }
}