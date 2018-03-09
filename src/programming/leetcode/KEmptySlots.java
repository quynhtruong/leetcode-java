package programming.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class KEmptySlots {
    class Node {
        int val, min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public Deque<Node> headStack = new LinkedList<>();
    public Deque<Node> tailStack = new LinkedList<>();

    public void push(int val, Deque<Node> stack) {
        if (stack.isEmpty()) {
            stack.addLast(new Node(val, val));
        } else {
            int min = stack.peekLast().min;
            stack.addLast(new Node(val, Math.min(val, min)));
        }
    }

    public void push(int val) {
        push(val, tailStack);
    }

    public void pop() {
        if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                push(tailStack.removeLast().val, headStack);
            }
        }
        headStack.removeLast();
    }

    public int getMin() {
        int result = Integer.MAX_VALUE;
        if (!headStack.isEmpty()) result = Math.min(result, headStack.peekLast().min);
        if (!tailStack.isEmpty()) result = Math.min(result, tailStack.peekLast().min);
        return result;
    }

    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (n <= k) return -1;
        int[] day = new int[n];
        for (int i = 0; i < n; i++) {
            day[flowers[i] - 1] = i + 1;
        }
        for (int i = 0; i <= k; i++) {
            push(day[i]);
        }
        int[] minVal = new int[n];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (headStack.size() + tailStack.size() == k + 1) {
                minVal[i] = getMin();
                pop();
            }
            if (i + k + 1 < n) {
                push(day[i + k + 1]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - k - 1; i++) {
            if (minVal[i] == day[i] && minVal[i + 1] == day[i + k + 1]) {
                result = Math.min(result, Math.max(day[i], day[i + k + 1]));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        KEmptySlots solution = new KEmptySlots();
        int[] flowers = new int[]{1,3,2};
        System.out.println(solution.kEmptySlots(flowers, 0));
    }
}
