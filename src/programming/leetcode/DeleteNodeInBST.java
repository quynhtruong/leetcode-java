package programming.leetcode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode node = root;
        TreeNode p = null;
        while (node != null) {
            if (node.val == key) break;
            p = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (node == null) return root; //not found
        if (node.left != null) {
            TreeNode maxLeft = node.left;
            TreeNode parent = node;
            while (maxLeft.right != null) {
                parent = maxLeft;
                maxLeft = maxLeft.right;
            }
            node.val = maxLeft.val;
            if (parent.left == maxLeft) {
                parent.left = maxLeft.left;
            } else {
                parent.right = maxLeft.left;
            }
            return root;
        } else if (node.right != null) {
            TreeNode minRight = node.right;
            TreeNode parent = node;
            while (minRight.left != null) {
                parent = minRight;
                minRight = minRight.left;
            }
            node.val = minRight.val;
            if (parent.left == minRight) {
                parent.left = minRight.right;
            } else {
                parent.right = minRight.right;
            }
            return root;
        } else { //no children
            if (p == null) return null;
            if (p.left == node) p.left = null;
            else p.right = null;
            return root;
        }
    }
}
