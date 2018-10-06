package programming.leetcode;

import java.util.*;

/**
 * Created by truongq on 5/25/18.
 */
public class ExpressionAndOperator {
    public static final List<String> operators = Arrays.asList("", "+", "-", "*");

    public List<String> addOperators(String num, int target) {
        int n = num.length();
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1) return target == num.charAt(0) - '0' ? Arrays.asList(num) : result;
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        visit(1, num, sb, target, result);
        return result;
    }

    public void visit(int index, String num, StringBuilder sb, int target, List<String> result) {
        for (String s : operators) {
            sb.append(s);
            sb.append(num.charAt(index));
            if (index == num.length() - 1) {
                checkResult(sb, target, result);
            } else {
                visit(index + 1, num, sb, target, result);
            }
            sb.deleteCharAt(sb.length() - 1);
            if ("".equals(s)) sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void checkResult(StringBuilder temp, int target, List<String> result) {
        String s = temp.toString();
        int len = s.length();
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || i == len - 1) {
                if (i == len - 1) sb.append(ch);
                Long next = Long.parseLong(sb.toString());
                if (!stack.isEmpty() && "*".equals(stack.peekLast())) {
                    stack.removeLast();
                    long operand = Long.parseLong(stack.removeLast());
                    stack.addLast(String.valueOf(operand * next));
                }
                if (i != len - 1) stack.addLast(s.substring(i, i + 1));
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }//end for i
        long total = 0;
        while(!stack.isEmpty()) {
            Long top = Long.parseLong(stack.removeLast());
            if (!stack.isEmpty()) {
                String operator = stack.removeLast();
                if ("-".equals(operator)) total -= top;
                else total += top;
            }
        }
        if (total == target) result.add(s);
    }

}
