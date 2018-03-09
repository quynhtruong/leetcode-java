package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by quuynh on 30/06/17.
 */
public class LowestCommonAncestor {

    private void findPath(Deque<TreeNode> nodeStack, TreeNode node, TreeNode targetNode) {
        if (node == null) return;
        if (!nodeStack.isEmpty() && nodeStack.peekLast().equals(targetNode)) return;
        nodeStack.offerLast(node);
        if (node.equals(targetNode)) return;
        findPath(nodeStack, node.left, targetNode);
        findPath(nodeStack, node.right, targetNode);
        if (!nodeStack.peekLast().equals(targetNode)) nodeStack.removeLast();
    }

    public TreeNode lowestCommonAncestorOriginal(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pPath = new LinkedList<>();
        findPath(pPath, root, p);
        Deque<TreeNode> qPath = new LinkedList<>();
        findPath(qPath, root, q);
        while (pPath.size() != qPath.size()) {
            if (pPath.size() > qPath.size()) pPath.removeLast();
            else qPath.removeLast();
        }
        while (pPath.peekLast() != qPath.peekLast()) {
            pPath.removeLast();
            qPath.removeLast();
        }
        return pPath.peekLast();
    }

    private TreeNode result = null;

    private Integer visit(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return 0;
        if (result != null) return 0;
        Integer total = 0;
        if (node == p || node == q) total++;
        Integer leftResult = visit(node.left, p, q);
        Integer rightResult = visit(node.right, p, q);
        total += leftResult + rightResult;
        if (total == 2 && result == null) {
            result = node;
        }
        return total;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        visit(root, p, q);
        return result;
    }


}
