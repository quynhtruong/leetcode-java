package programming.leetcode;

/**
 * Created by quuynh on 09/06/17.
 */
public class RemoveNthNodeFromTheEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        if (n == 0) return head;
        fakeHead.next = head;
        ListNode fastNode = fakeHead;
        while (fastNode != null) {
            n--;
            fastNode = fastNode.next;
            if (n == 0) break;
        }
        if (fastNode == null) return head; //not enough
        ListNode slowNode = fakeHead;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return fakeHead.next;
    }
}
