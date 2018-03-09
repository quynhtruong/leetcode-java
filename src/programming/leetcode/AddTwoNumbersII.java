package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII {
    public Deque<Integer> buildStack(ListNode l) {
        Deque<Integer> result = new LinkedList<>();
        while (l != null) {
            result.addLast(l.val);
            l = l.next;
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = buildStack(l1);
        Deque<Integer> stack2 = buildStack(l2);
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int top1 = stack1.removeLast();
            int top2 = stack2.removeLast();
            ListNode newHead = new ListNode((top1 + top2 + carry) % 10);
            carry = (top1 + top2 + carry) / 10;
            newHead.next = head;
            head = newHead;
        }
        Deque<Integer> stack = stack1.isEmpty() ? stack2 : stack1;
        while (!stack.isEmpty()) {
            int top = stack.removeLast();
            ListNode newHead = new ListNode((top + carry) % 10);
            carry = (top + carry) / 10;
            newHead.next = head;
            head = newHead;
        }
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
}
