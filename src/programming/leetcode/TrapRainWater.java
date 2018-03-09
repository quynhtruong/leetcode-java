package programming.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by quuynh on 15/06/17.
 */
class Node {
    int height, width;
    Node left, right;

    public Node(int height, int width) {
        this.height = height;
        this.width = width;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return n1.height - n2.height;
    }
}

public class TrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(height[i], 1);
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) nodes[i].left = nodes[i - 1];
            if (i < n - 1) nodes[i].right = nodes[i + 1];
            queue.offer(nodes[i]);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null && node.right != null) {
                int minHeight = Math.min(node.left.height, node.right.height);
                if (minHeight >= node.height) {
                    result += (minHeight - node.height) * node.width;
                }
                if (node.left.height == minHeight) {
                    node.left.width += node.width;
                } else {
                    node.right.width += node.width;
                }
                node.left.right = node.right;
                node.right.left = node.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrapRainWater solution = new TrapRainWater();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        solution.trap(heights);
    }
}
