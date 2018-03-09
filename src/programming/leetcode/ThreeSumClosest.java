package programming.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by quuynh on 13/06/17.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        long result = 2 * (long) Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int jj = n - 1;
            for (int j = i + 1; j < n; j++) {
                int u = jj;
                while (u > j + 1 && nums[i] + nums[j] + nums[u] >= target) u--;
                jj = u;
                if (u < n - 1 && Math.abs(result - target) > Math.abs((long) nums[i] + nums[j] + nums[u + 1] - target)) {
                    result = (long) nums[i] + nums[j] + nums[u + 1];
                }
                if (u > j && Math.abs(result - target) > Math.abs((long) nums[i] + nums[j] + nums[u] - target)) {
                    result = (long) nums[i] + nums[j] + nums[u];
                }
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] input = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(input, 1));

    }
}
