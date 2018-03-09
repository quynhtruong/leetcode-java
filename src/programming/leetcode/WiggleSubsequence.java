package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
            } else if (stack.get(stack.size() - 1) != num) {
                while (stack.size() > 1 && ((num - stack.get(stack.size() - 1)) * (stack.get(stack.size() - 1) - stack.get(stack.size() - 2)) > 0))
                    stack.remove(stack.size() - 1);
                stack.add(num);
            }
            System.out.println(stack);
        }
        return stack.size();
    }
}

