package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.addLast(ch);
            } else {
                if (stack.isEmpty() || (ch == ')' && stack.peekLast() != '(') || (ch == ']' && stack.peekLast() != '[') || (ch == '}' && stack.peekLast() != '{'))
                    return false;
                stack.removeLast();
            }
        }//end for i
        return stack.isEmpty();
    }

}