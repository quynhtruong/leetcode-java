package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 03/07/17.
 */
public class SplitArrayLargestSum {
    public boolean check(long limit, long[] sum, int m) {
        int n = sum.length;
        int[] f = new int[n];
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] <= limit) {
                f[i] = 1;
            } else {
                for (int j = last; j < i; j++)
                    if (sum[i] - sum[j] <= limit) {
                        f[i] = f[j] + 1;
                        last = j;
                        break;
                    }
            }
        }
        return f[n - 1] <= m;
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        long[] sum = new long[n];
        Arrays.fill(sum, 0);
        long maxValue = nums[0];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            maxValue = Math.max(maxValue, (long) nums[i]);
        }
        long left = maxValue, right = sum[n - 1] + 1;
        if (check(left, sum, m)) return (int) left;
        while (left < right - 1) {
            long mid = (left + right) / 2;
            if (check(mid, sum, m)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (int) right;
    }
}
