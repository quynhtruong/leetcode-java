package programming.leetcode;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, countSoFar = 0;
        for (int num : nums) {
            if (num == 1) {
                countSoFar++;
                result = Math.max(result, countSoFar);
            } else {
                countSoFar = 0;
            }
        }
        return result;
    }
}
