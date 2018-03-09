package programming.leetcode;


/**
 * Created by quuynh on 16/06/17.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        int minValue = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            result = Math.max(result, sum[i]);
            result = Math.max(result, sum[i] - minValue);
            if (sum[i] < minValue) minValue = sum[i];
        }
        return result;
    }

}
