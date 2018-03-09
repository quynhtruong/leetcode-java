package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 25/05/17.
 */


public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Integer>> pairMap = new HashMap<>();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> pairSet = pairMap.get(nums[i]);
            if (pairSet == null) pairSet = new HashSet<>();
            int jj = n - 1;
            for (int j = i + 1; j < n - 1; j++)
                if (-(nums[i] + nums[j]) >= nums[j] && !pairSet.contains(nums[j])) {
                    for (int u = jj; u > j; u--)
                        if (nums[i] + nums[j] + nums[u] <= 0) {
                            if (nums[i] + nums[j] + nums[u] == 0) {
                                result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[u])));
                                pairSet.add(nums[j]);
                            }
                            jj = u;
                            break;
                        }
                }
            pairMap.put(nums[i], pairSet);
        }
        return result;
    }

    public static void main(String args[]) {
//        int[] input = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,};
//        int[] input = {-1, 0, 1, 2, -1, -4};
        int[] input = {0, -4, -1, -4, -2, -3, 2};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(input);
        for (List<Integer> integers : result) {
            System.out.println(integers.get(0) + " " + integers.get(1) + " " + integers.get(2));
        }
    }
}
