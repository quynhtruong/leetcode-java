package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 16/06/17.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        int maxReach = nums[0];
        for (int i = 1; i < n; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        result.set(0, 10);
        return true;
    }

}
