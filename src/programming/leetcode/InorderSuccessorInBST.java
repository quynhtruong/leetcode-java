package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        visit(root, p, stack);
        p = stack.removeLast();
        while (!stack.isEmpty()) {
            TreeNode q = stack.removeLast();
            if (q.left == p) return q;
            p = q;
        }
        return null;
    }

    public void visit(TreeNode node, TreeNode p, Deque<TreeNode> stack) {
        if (!stack.isEmpty() && stack.peekLast() == p) {
            return;
        }
        stack.addLast(node);
        if (node == p) return;
        if (node.left != null) {
            visit(node.left, p, stack);
            if (stack.peekLast() == p) return;
            stack.removeLast();
        }
        if (node.right != null) {
            visit(node.right, p, stack);
            if (stack.peekLast() == p) return;
            stack.removeLast();
        }
    }
}

