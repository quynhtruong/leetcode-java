package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        if (nodeMap.get(head) != null) {
            return nodeMap.get(head);
        } else {
            RandomListNode result = new RandomListNode(head.label);
            nodeMap.put(head, result);
            result.next = copyRandomList(head.next);
            result.random = copyRandomList(head.random);
            return result;
        }
    }
}
