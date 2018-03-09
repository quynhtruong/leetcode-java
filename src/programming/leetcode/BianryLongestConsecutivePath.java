package programming.leetcode;

/**
 * Created by quuynh on 07/06/17.
 */
public class BianryLongestConsecutivePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result = 0;

    private int visit(TreeNode node) {
        if (node == null) return 0;
        int leftResult = visit(node.left);
        int rightResult = visit(node.right);
        int maxHeight = 1;
        if (node.left != null && node.left.val == node.val + 1) maxHeight = Math.max(maxHeight, leftResult + 1);
        if (node.right != null && node.right.val == node.val + 1) maxHeight = Math.max(maxHeight, rightResult + 1);
        result = Math.max(result, maxHeight);
        return maxHeight;
    }

    public int longestConsecutive(TreeNode root) {
        visit(root);
        return result;
    }
}
