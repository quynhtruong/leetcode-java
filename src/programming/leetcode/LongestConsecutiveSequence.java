package programming.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by quuynh on 04/07/17.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : nums)
            if (numSet.contains(num)) {
                int countRange = 1;
                //expand to right
                Integer iterator = num + 1;
                while (numSet.contains(iterator)) {
                    countRange++;
                    numSet.remove(iterator++);
                }
                //expand to right
                iterator = num - 1;
                while (numSet.contains(iterator)) {
                    countRange++;
                    numSet.remove(iterator--);
                }
                result = Math.max(result, countRange);
            }
        return result;
    }
}
