package programming.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by quuynh on 15/06/17.
 */
public class FirstMissingPositiveInterger {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        numSet.add(0);
        for (Integer num : nums) {
            numSet.add(num);
        }
        int result = Integer.MAX_VALUE;
        for (Integer num : numSet) {
            if (num + 1 > 0 && !numSet.contains(num + 1)) result = Math.min(result, num + 1);
        }
        return result;
    }
}
