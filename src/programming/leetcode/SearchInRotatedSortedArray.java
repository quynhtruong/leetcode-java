package programming.leetcode;

/**
 * Created by quuynh on 14/06/17.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int left = 0, right = n - 1;
        while (right > left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (target >= nums[left]) {
                if (nums[mid] >= target || nums[mid] < nums[left]) right = mid;
                else left = mid + 1;
            } else {
                if (nums[mid] >= nums[left] || nums[mid] < target) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        System.out.println(search(nums, 1));
    }
}
