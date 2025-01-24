class Solution {
    public int solution(String myString, String pat) {
        String change = "";
        for (String i : myString.split("")) {
            if (i.equals("A"))
                change += "B";
            else
                change += "A";
        }
        int answer = 0;
        if (myString.length() >= pat.length()) {
            for (int i = 0; i <= myString.length() - pat.length(); i++) {
                if(change.substring(i, i+pat.length()).equals(pat))
                    answer = 1;
            }
        }
        else {
            answer = 0;
        }
        return answer;
    }
}