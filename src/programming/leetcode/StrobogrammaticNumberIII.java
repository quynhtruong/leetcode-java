package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumberIII {
    private Map<Integer, Integer> symetricMap;
    private int result = 0;

    public int strobogrammaticInRange(String low, String high) {
        symetricMap = new HashMap<>();
        symetricMap.put(0, 0);
        symetricMap.put(1, 1);
        symetricMap.put(6, 9);
        symetricMap.put(8, 8);
        symetricMap.put(9, 6);

        int m = low.length();
        int n = high.length();
        result = 0;
        for (int i = m; i <= n; i++) {
            build(i, low, high);
        }
        return result;
    }

    private void build(int len, String low, String high) {
        int[] nums = new int[len];
        generate(0, len - 1, nums, low, high);
    }

    private void generate(int start, int end, int[] nums, String low, String high) {
        if (start == end) {
            for (Integer key : symetricMap.keySet()) {
                if (key == symetricMap.get(key)) {
                    nums[start] = key;
                    addResult(nums, low, high);
                }
            }
        } else { //start != end
            for (Integer key : symetricMap.keySet()) {
                nums[start] = key;
                nums[end] = symetricMap.get(key);
                if (start == end - 1) {
                    addResult(nums, low, high);
                } else {
                    generate(start + 1, end - 1, nums, low, high);
                }
            }
        }
    }

    private void addResult(int[] nums, String low, String high) {
        if (nums.length > 1 && nums[0] == 0) return;
        StringBuilder sb = new StringBuilder();
        for (int value : nums) sb.append(value);
        String candidate = sb.toString();
        if (compare(candidate, low) >= 0 && compare(candidate, high) <= 0) result++;
    }

    private int compare(String a, String b) {
        if (a.length() > b.length()) return 1;
        if (a.length() < b.length()) return -1;
        return a.compareTo(b);
    }
}
