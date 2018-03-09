package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 16/06/17.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        Arrays.sort(nums);
        int result = 0;
        long maxReach = 0;
        for (Integer num : nums) {
            Integer threshold = Math.min(n, num - 1);
            while (maxReach < threshold) {
                maxReach = maxReach + maxReach + 1;
                result++;
            }
            if (maxReach >= n) return result;
            maxReach += num;
        }
        while (maxReach < n) {
            maxReach = maxReach + maxReach + 1;
            result++;
        }
        return result;
    }

}
