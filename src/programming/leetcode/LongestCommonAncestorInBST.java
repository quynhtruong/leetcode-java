package programming.leetcode;

/**
 * Created by quuynh on 05/07/17.
 */
public class LongestCommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode result = root;
        while (result.val > Math.max(p.val, q.val) || result.val < Math.min(p.val, q.val)) {
            if (result.val > Math.max(p.val, q.val)) result = result.left;
            else result = result.right;
        }
        return result;
    }
}
