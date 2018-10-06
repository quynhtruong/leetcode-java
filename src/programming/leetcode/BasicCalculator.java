package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by truongq on 5/23/18.
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = "("+s+")";
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-') {
                if (sb.length() > 0) {
                    stack.addLast(sb.toString());
                    sb = new StringBuilder();
                }
                stack.addLast(s.substring(i, i+1));
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == ')') {
                if (sb.length() > 0) {
                    stack.addLast(sb.toString());
                    sb = new StringBuilder();
                }
                int element = 0;
                String operator = "";
                while(!"(".equals(operator)) {
                    int operand = Integer.parseInt(stack.removeLast());
                    operator = stack.removeLast();
                    if ("(".equals(operator) || "+".equals(operator)) element += operand;
                    if ("-".equals(operator)) element -= operand;
                }
                stack.addLast(String.valueOf(element));
            }
        }//end for i
        return Integer.parseInt(stack.removeLast());
    }
}
