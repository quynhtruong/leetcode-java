package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 14/06/17.
 */

public class ReverseNodesInKGroup {
    private List<ListNode> reverse(ListNode head, ListNode tail) {
        ListNode currentNode = head;
        ListNode p = head.next;
        while (p != tail) {
            ListNode q = p.next;
            p.next = currentNode;
            currentNode = p;
            p = q;
        }
        tail.next = currentNode;
        return Arrays.asList(tail, head);
    }

    private ListNode partition(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;
        int count = 1;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
            if (count == k) break;
        }
        if (currentNode == null) return head;
        ListNode nextHead = partition(currentNode.next, k);
        List<ListNode> listNodes = reverse(head, currentNode);
        listNodes.get(1).next = nextHead;
        return listNodes.get(0);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return partition(head, k);
    }
}
