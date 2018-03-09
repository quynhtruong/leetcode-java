package programming.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by quuynh on 15/06/17.
 */

public class TrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > height[i] && right[i] > height[i]) {
                result += Math.min(left[i], right[i]) - height[i];
            }
        }
        return result;
    }
}
