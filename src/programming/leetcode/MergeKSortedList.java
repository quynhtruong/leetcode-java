package programming.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by quuynh on 13/06/17.
 */

class MyComparator implements Comparator<ListNode> {
    public int compare(ListNode l1, ListNode l2) {
        return l1.val - l2.val;
    }
}

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new MyComparator());
        ListNode fakeHead = new ListNode(-1);
        ListNode currentTail = fakeHead;
        for (ListNode listNode : lists)
            if (listNode != null) {
                queue.offer(listNode);
            }

        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            System.out.println(listNode.val);
            ListNode nextNode = new ListNode(listNode.val);
            currentTail.next = nextNode;
            currentTail = nextNode;
            if (listNode.next != null) queue.offer(listNode.next);
        }
        return fakeHead.next;
    }
}
