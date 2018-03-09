package programming.leetcode;

/**
 * Created by quuynh on 13/06/17.
 */


public class SwapNodeInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode currentNode = fakeHead;
        while (currentNode != null) {
            ListNode p = currentNode.next;
            if (p == null) break;
            ListNode q = p.next;
            if (q == null) break;
            p.next = q.next;
            q.next = p;
            currentNode.next = q;
            currentNode = p;
        }
        return fakeHead.next;
    }
}
