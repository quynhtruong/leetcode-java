package programming.leetcode;

import java.util.*;

public class CountNumberOfSmallerAfterItSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        if (n == 0) return result;
        int[] tempArr = Arrays.copyOf(nums, n);
        Arrays.sort(tempArr);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(tempArr[i], i);
        }
        for (int i = 0; i < n; i++) nums[i] = indexMap.get(nums[i]) + 1;
        System.out.println();
        int[] bit = new int[n + 2];
        int[] freq = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            //get value
            freq[nums[i]]++;
            int count = bit[nums[i]];
            int j = nums[i] - (nums[i] & (-nums[i]));
            while (j != 0) {
                count = count + bit[j] + freq[j];
                j = j - (j & (-j));
            }
            result.set(i, count);

            j = nums[i] + (nums[i] & (-nums[i]));
            while (j <= n) {
                bit[j] = bit[j] + 1;
                j = j + (j & (-j));
            }
        }//end for i
        return result;
    }
}
