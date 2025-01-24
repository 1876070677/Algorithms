import java.util.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if (arr1.length > arr2.length)
            return 1;
        else if (arr2.length > arr1.length)
            return -1;
        else {
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            if (sum1 > sum2)
                return 1;
            else if (sum2 > sum1)
                return -1;
            else
                return 0;
        }
    }
}