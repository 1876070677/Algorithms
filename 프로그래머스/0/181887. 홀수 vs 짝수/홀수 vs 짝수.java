class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < num_list.length; i++) {
            if ((i+1)%2 == 1)
                sumA += num_list[i];
            else
                sumB += num_list[i];
        }
        return sumA > sumB ? sumA : sumB;
    }
}