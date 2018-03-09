package programming.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] sum = new int[n];
        Arrays.fill(sum, 0);
        Map<Integer, Integer> countMap = new HashMap<>();
        sum[0] = nums[0];
        countMap.put(sum[0], 1);
        int result = sum[0] == k ? 1 : 0;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (sum[i] == k) result++;
            Integer previousCount = countMap.get(sum[i] - k);
            result += previousCount != null ? previousCount : 0;
            Integer currentCount = countMap.get(sum[i]);
            if (currentCount == null) currentCount = 0;
            countMap.put(sum[i], currentCount + 1);
        }
        return result;
    }
}
