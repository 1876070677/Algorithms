class Solution {
    public int[] solution(int[] arr, int n) {
        int startPoint = arr.length % 2 == 1 ? 0 : 1;
        for (int i = startPoint; i < arr.length; i++) {
            arr[i] += n;
            i++;
        }
        return arr;
    }
}