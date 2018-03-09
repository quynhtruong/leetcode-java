package programming.leetcode;

public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
