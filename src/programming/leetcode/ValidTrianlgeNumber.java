package programming.leetcode;

import java.util.Arrays;

public class ValidTrianlgeNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int last = i + 1;
            for (int j = i + 1; j < n; j++) {
                int u = last;
                while (u < n && nums[u] < nums[i] + nums[j]) u++;
                last = u;
                if (u > j) result += u - j - 1;
            }
        }
        return result;
    }
}
