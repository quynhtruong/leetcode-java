package programming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthInBinaryTree {
    public Map<Integer, Integer> left, right;

    public void visit(TreeNode node, Integer currentLayer, Integer currentWidth) {
        if (node == null) return;
        Integer minLeft = left.get(currentLayer);
        Integer maxRight = right.get(currentLayer);
        if (minLeft == null || minLeft > currentWidth) minLeft = currentWidth;
        if (maxRight == null || maxRight < currentWidth) maxRight = currentWidth;
        left.put(currentLayer, minLeft);
        right.put(currentLayer, maxRight);
        visit(node.left, currentLayer + 1, 2 * currentWidth);
        visit(node.right, currentLayer + 1, 2 * currentWidth + 1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        left = new HashMap<>();
        right = new HashMap<>();
        visit(root, 0, 0);
        int result = 0;
        for (Integer layer : left.keySet()) {
            result = Math.max(result, right.get(layer) - left.get(layer));
        }
        return result + 1;
    }
}

