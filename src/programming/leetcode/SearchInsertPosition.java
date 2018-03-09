package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 14/06/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        if (pos>=0) return pos;
        return Math.abs(pos)-1;
    }
}
