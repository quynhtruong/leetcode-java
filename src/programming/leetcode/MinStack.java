package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by quuynh on 29/06/17.
 */
public class MinStack {
    public class StackNode {
        public int value;
        public int minValue;

        public StackNode(int value, int maxValue) {
            this.value = value;
            this.minValue = maxValue;
        }
    }

    private Deque<StackNode> stack = new LinkedList<>();

    public MinStack() {
        stack.clear();
    }

    public void push(int x) {
        int minValue = stack.isEmpty() ? x : Math.min(x, stack.peekLast().minValue);
        stack.offer(new StackNode(x, minValue));
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pollLast();
    }

    public int top() {
        return stack.peekLast().value;
    }

    public int getMin() {
        return stack.peekLast().minValue;
    }
}
