class Solution {
    public String solution(String myString) {
        String answer = "";
        for (String i : myString.split("")) {
            if (i.equals("a") || i.equals("A"))
                answer += "A";
            else
                answer += i.toLowerCase();
        }
        return answer;
    }
}