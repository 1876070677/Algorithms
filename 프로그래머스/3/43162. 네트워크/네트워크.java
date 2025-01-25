import java.util.*;
class Solution {
    Queue<Integer> q = new LinkedList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[computers.length];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 0) {
                answer += 1;
                q.add(i);
                while(!q.isEmpty()) {
                    int node = q.poll();
                    if (visited[node] == 1)
                        continue;
                    visited[node] = 1;
                    for (int j = 0; j < computers[node].length; j++) {
                        if (computers[node][j] > 0) {
                            q.add(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}