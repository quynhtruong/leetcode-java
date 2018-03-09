package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 29/06/17.
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int[] countBit = new int[32];
        Arrays.fill(countBit, 0);
        int n = nums.length;
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >>> i) & 1) == 1) countBit[i]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) result += countBit[i] * (n - countBit[i]);
        return result;
    }

    public static void main(String[] args) {
        TotalHammingDistance solution = new TotalHammingDistance();
        int[] nums = {4, 14, 2};
        System.out.print(solution.totalHammingDistance(nums));
    }
}
