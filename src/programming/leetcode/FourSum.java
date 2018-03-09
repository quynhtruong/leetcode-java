package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 13/06/17.
 */
public class FourSum {
    class Pair {
        Integer first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    private boolean checkExist(List<List<Integer>> result, List<Integer> newOutput) {
        if (result.isEmpty()) return false;
        List<Integer> top = result.get(result.size() - 1);
        for (int i = 0; i < 4; i++) if (!top.get(i).equals(newOutput.get(i))) return false;
        return true;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<Pair>> pairMap = new HashMap<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                Integer sum = nums[i] + nums[j];
                if (pairMap.get(sum) == null) pairMap.put(sum, new ArrayList<>());
                pairMap.get(sum).add(new Pair(i, j));
            }

        Map<Integer, Set<Integer>> matchMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> matchSet = matchMap.get(nums[i]);
            if (matchSet == null) matchSet = new HashSet<>();
            for (int j = i + 1; j < n; j++)
                if (!matchSet.contains(nums[j])) { //nums[i] and nums[j] has not been a pair
                    List<Pair> pairList = pairMap.get(target - nums[i] - nums[j]);
                    if (pairList != null) {
                        for (Pair pair : pairList)
                            if (pair.first > j) {
                                List<Integer> newOutput = Arrays.asList(nums[i], nums[j], nums[pair.first], nums[pair.second]);
                                if (!checkExist(result, newOutput)) {
                                    result.add(newOutput);
                                    matchSet.add(nums[j]);
                                }
                            }
                    }
                }
            matchMap.put(nums[i], matchSet);
        }
        return result;
    }
}
