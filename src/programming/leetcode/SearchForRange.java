package programming.leetcode;

/**
 * Created by quuynh on 14/06/17.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;
        if (n == 0 || nums[0] > target || nums[n - 1] < target) return result;
        int left = 0, right = n;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        int first = right;
        left = 0;
        right = n;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) right = mid;
            else left = mid;
        }
        if (first > left) {
            return result;
        }
        result = new int[]{first, left};
        return result;
    }
}
