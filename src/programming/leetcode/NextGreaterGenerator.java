package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 30/06/17.
 */
public class NextGreaterGenerator {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        for (int num : nums) {
            numList.add(num);
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = numList.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= numList.get(i)) stack.removeLast();
            Integer value = -1;
            if (!stack.isEmpty()) value = stack.peekLast();
            stack.addLast(numList.get(i));
            if (i < n) result[i] = value;
        }
        return result;
    }
}
