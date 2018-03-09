package programming.leetcode;

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            count+= nums[i];
            left[i] = count;
            if (nums[i] == 0) count = 0;
        }
        int result = 0;
        count = 0;
        for(int i = n - 1; i >= 0; i--) {
            count+= nums[i];
            result = Math.max(result, count);
            result = Math.max(result, left[i]);
            if (nums[i] == 0) {
                result = Math.max(result, left[i] + count + 1);
                count = 0;
            }
        }
        return result;
    }

}
