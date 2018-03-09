package programming.leetcode;

/**
 * Created by quuynh on 16/07/17.
 */
public class FindThePeakLement {
    private boolean isPeakElement(int mid, int[] nums) {
        if (mid == 0) {
            return nums.length == 1 || nums[mid] > nums[mid + 1];
        }
        if (mid == nums.length - 1) {
            return nums.length == 1 || nums[mid] > nums[mid - 1];
        }
        return nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1];
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPeakElement(mid, nums)) return mid;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
