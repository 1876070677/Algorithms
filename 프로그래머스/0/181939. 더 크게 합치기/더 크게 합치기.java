class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String aa = Integer.toString(a);
        String bb = Integer.toString(b);
        
        int ab = Integer.parseInt(aa + bb);
        int ba = Integer.parseInt(bb + aa);
        return ab > ba ? ab : ba;
    }
}