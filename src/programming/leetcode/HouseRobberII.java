package programming.leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1];
            if (i > 1) left[i] = Math.max(left[i - 2] + nums[i], left[i]);
        }
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (i < n - 2) right[i] = Math.max(right[i], right[i + 2] + nums[i]);
        }//end for i
        return Math.max(left[n - 1], right[0]);
    }

}
