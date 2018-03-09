package programming.leetcode;


/**
 * Created by quuynh on 20/06/17.
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode currentNode = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                currentNode = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                currentNode = l2;
                l2 = l2.next;
            }
        }
        currentNode.next = l1 != null ? l1 : l2;
        return fakeHead.next;
    }
}
