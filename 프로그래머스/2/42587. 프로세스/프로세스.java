import java.util.*;
class Process {
    int id;
    int pr;
    
    public Process(int id, int pr) {
        this.id = id;
        this.pr = pr;
    }
    
    public boolean isExecute(Queue<Process> q) {
        boolean chk = true;
        for (Process p: q) {
            if (p.pr > this.pr) {
                chk = false;
                break;
            }
        }
        return chk;
    }
}
class Solution {
    Queue<Process> q = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }
        
        int cnt = 1;
        while (true) {
            Process p = q.poll();
            
            if (p.isExecute(q)) {
                if (p.id == location) {
                    break;
                } else {
                    cnt++;
                }
            } else {
                q.add(p);
            }
        }
        return cnt;
    }
}