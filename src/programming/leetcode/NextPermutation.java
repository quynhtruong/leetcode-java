package programming.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by quuynh on 14/06/17.
 */
public class NextPermutation {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) index--;
        if (index == 0) {
            for (int i = 0; i < n / 2; i++) swap(nums, i, n - i - 1);
            for (Integer value : nums) System.out.println(value);
            return;
        }
        int chosenIndex = index;
        for (int i = index; i < n; i++) if (nums[i] > nums[index - 1] && nums[i] < nums[chosenIndex]) chosenIndex = i;
        swap(nums, index - 1, chosenIndex);
        Arrays.sort(nums, index, n);
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = {5, 1, 1};
        solution.nextPermutation(nums);
    }
}
