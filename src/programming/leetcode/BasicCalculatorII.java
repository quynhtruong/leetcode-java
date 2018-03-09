package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' ||ch == '-' ||ch == '*' ||ch == '/' ||Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        s = sb.toString();
        int n = sb.length();
        Deque<String> stack = new LinkedList<>();
        int first = 0;
        while (first < n) {
            char ch = s.charAt(first);
            if (ch == '/' ||ch =='*' ||ch =='+' ||ch =='-'){
                stack.addLast(s.substring(first, first + 1));
                first++;
            } else{
                int last = first;
                while (last < n && Character.isDigit(s.charAt(last))) last++;
                Integer value = Integer.parseInt(s.substring(first, last));
                first = last;
                if (!stack.isEmpty() && (stack.peekLast().equals("/") ||stack.peekLast().equals("*"))) {
                    String operation = stack.removeLast();
                    Integer preValue = Integer.parseInt(stack.removeLast());
                    Integer newValue = operation.equals("/") ?preValue / value:preValue * value;
                    stack.addLast(newValue.toString());
                } else{
                    stack.addLast(value.toString());
                }
            }
        }//end while loop
        int result = 0;
        while (!stack.isEmpty()) {
            Integer value = Integer.parseInt(stack.removeLast());
            if (!stack.isEmpty()) {
                String operation = stack.removeLast();
                if ("-".equals(operation))result -= value;
                else result += value;
            } else {
                result += value;
            }
        }
        return result;
    }

}
