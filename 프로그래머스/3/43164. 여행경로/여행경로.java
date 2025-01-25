import java.util.*;
class Solution {
    ArrayList<String> comb = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();
    int maxAirPort;
    public void dfs(String start, int depth, String[][] tickets, int[] visited) {
        if (depth == maxAirPort) {
            String temp = "";
            for (int i = 0; i < comb.size(); i++) {
                temp += comb.get(i);
            }
            answers.add(temp);
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i][0].equals(start) && visited[i] == 0) {
                    comb.add(tickets[i][1]);
                    visited[i] = 1;
                    dfs(tickets[i][1], depth+1, tickets, visited);
                    comb.remove(comb.size()-1);
                    visited[i] = 0;
                }
            }  
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        maxAirPort = tickets.length + 1;
        int[] visited = new int[tickets.length];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;
        comb.add("ICN");
        dfs("ICN", 1, tickets, visited);
        Collections.sort(answers);
        String t = answers.get(0);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = t.substring(i*3, i*3+3);
        }
        return answer;
    }
}