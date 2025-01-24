class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        if (myString.length() >= pat.length()) {
            for (int i = 0; i <= myString.length() - pat.length(); i++){
                if (myString.substring(i, i + pat.length()).toLowerCase().equals(pat.toLowerCase()))
                    answer = 1;
            }   
        }
        return answer;
    }
}