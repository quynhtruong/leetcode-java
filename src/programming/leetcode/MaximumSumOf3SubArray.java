package programming.leetcode;

import java.util.Arrays;

public class MaximumSumOf3SubArray {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        Arrays.fill(sum, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = -1;
            right[i] = -1;
        }
        //calculate left
        left[k - 1] = k - 1;
        maxLeft[k - 1] = sum[k - 1];
        for (int i = k; i < n; i++) {
            left[i] = left[i - 1];
            maxLeft[i] = maxLeft[i - 1];
            if (sum[i] - sum[i - k] > maxLeft[i]) {
                maxLeft[i] = sum[i] - sum[i - k];
                left[i] = i;
            }
        }
        //calculate right
        right[n - k] = n - k;
        maxRight[n - k] = sum[n - 1] - sum[n - k - 1];
        for (int i = n - k - 1; i >= 1; i--) {
            right[i] = right[i + 1];
            maxRight[i] = maxRight[i + 1];
            if (sum[i + k - 1] - sum[i - 1] >= maxRight[i]) {
                maxRight[i] = sum[i + k - 1] - sum[i - 1];
                right[i] = i;
            }
        }
        int result = -1;
        int[] value = new int[3];
        for (int i = 2 * k - 1; i < n - k; i++) {
            if (sum[i] - sum[i - k] + maxLeft[i - k] + maxRight[i + 1] > result) {
                result = sum[i] - sum[i - k] + maxLeft[i - k] + maxRight[i + 1];
                value[0] = left[i - k] - k + 1;
                value[1] = i - k + 1;
                value[2] = right[i + 1];
            }
        }
        return value;
    }
}
