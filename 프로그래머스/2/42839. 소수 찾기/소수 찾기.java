import java.util.*;

class Solution {
    int[] nums;
    int answer;
    int maxDepth;
    boolean[] maked;
    ArrayList<Integer> sel;
    
    public void init() {
        nums = new int[10];
        Arrays.fill(nums, 0);
        
        answer = 0;
        
        sel = new ArrayList<>();
        
        maked = new boolean[10000000];
        Arrays.fill(maked, false);
    }
    
    public int makeNumber() {
        int n = 0;
        for (int i = 0; i < sel.size(); i++) {
            n += (sel.get(i) * Math.pow(10, i));
        }
        
        return n;
    }
    
    public boolean isSosu(int n) {
        boolean chk = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                chk = false;
                break;
            }
        }
        return chk;
    }
    
    public void dfs(int depth) {
        if (depth == maxDepth) {
            // 숫자 만듬, sel에 들어있는 걸 기준으로
            int n = makeNumber();
            if (maked[n])
                return;
            
            if (n != 0 && n != 1) {
                // 소수 판별
                maked[n] = true;
                boolean chk = isSosu(n);
                if (chk) {
                    answer++;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i]--;
                    sel.add(i);
                    dfs(depth + 1);
                    sel.remove(sel.size()-1);
                    nums[i]++;
                }
            }
            // 선택안하고 넘어갈 수도 있음
            dfs(depth + 1);
        }
    }
    
    public int solution(String numbers) {
        init();
        
        for (int i = 0; i < numbers.length(); i++) {
            int n = Integer.parseInt(numbers.substring(i, i+1));
            nums[n]++;
        }
        
        maxDepth = numbers.length();
        dfs(0);
        
        return answer;
    }
}