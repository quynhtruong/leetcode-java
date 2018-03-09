package programming.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by quuynh on 01/07/17.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peekLast();
            if (node.left != null) {
                stack.addLast(node.left);
                node.left = null;
            } else {
                stack.removeLast();
                result.add(node.val);
                if (node.right != null) {
                    stack.addLast(node.right);
                    node.right = null;
                }
            }
        }
        return result;
    }
}
