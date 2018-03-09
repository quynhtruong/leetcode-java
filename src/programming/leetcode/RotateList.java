package programming.leetcode;

/**
 * Created by quuynh on 24/06/17.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k = k % n;
        if (k == 0) return head;
        tail.next = head;
        k++;
        ListNode node = head;
        while (k < n) {
            node = node.next;
            k++;
        }
        ListNode result = node.next;
        node.next = null;
        return result;
    }
}
