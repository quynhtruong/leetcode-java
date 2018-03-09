package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quuynh on 15/06/17.
 */
public class Permutations {
    private boolean[] free;
    private List<List<Integer>> result = new ArrayList<>();

    void visit(int[] nums, boolean[] free, List<Integer> temp) {
        for (int i = 0; i < nums.length; i++)
            if (free[i]) {
                free[i] = false;
                temp.add(nums[i]);
                if (temp.size() == nums.length) result.add(new ArrayList<>(temp));
                else visit(nums, free, temp);
                free[i] = true;
                temp.remove(temp.size() - 1);
            }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        free = new boolean[n];
        for (int i = 0; i < n; i++) free[i] = true;
        visit(nums, free, temp);
        return result;
    }
}
