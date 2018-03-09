package programming.leetcode;

/**
 * Created by quuynh on 26/05/17.
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2, result = new ListNode(0);
        ListNode currentNode = result;
        int carry = 0;
        while (head1 != null && head2 != null) {
            ListNode node = new ListNode((carry + head1.val + head2.val) % 10);
            carry = (carry + head1.val + head2.val) / 10;
            currentNode.next = node;
            currentNode = node;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            ListNode node = new ListNode((carry + head1.val) % 10);
            carry = (carry + head1.val) / 10;
            currentNode.next = node;
            currentNode = node;
            head1 = head1.next;
        }
        while (head2 != null) {
            ListNode node = new ListNode((carry + head2.val) % 10);
            carry = (carry + head2.val) / 10;
            currentNode.next = node;
            currentNode = node;
            head2 = head2.next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return result.next;
    }
}
