class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String aa = Integer.toString(a);
        String bb = Integer.toString(b);
        
        int ab = Integer.parseInt(aa + bb);
        int ab2 = 2 * a * b;
        return ab >= ab2 ? ab : ab2;
    }
}