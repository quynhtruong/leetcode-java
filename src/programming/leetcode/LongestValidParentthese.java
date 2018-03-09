package programming.leetcode;

import java.util.LinkedList;

/**
 * Created by quuynh on 14/06/17.
 */
public class LongestValidParentthese {
    public int longestValidParentheses(String s) {
        s = "$" + s;
        int n = s.length();
        int[] f = new int[n];
        int result = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(i);
            } else {
                if (!stack.isEmpty()) {
                    int top = stack.pollFirst();
                    f[i] = f[top - 1] + i - top + 1;
                }
            }
            result = Math.max(result, f[i]);
            System.out.println(f[i]);
        }
        return result;
    }
}
