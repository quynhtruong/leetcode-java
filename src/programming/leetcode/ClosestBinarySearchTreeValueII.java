package programming.leetcode;

import java.util.*;

/**
 * Created by truongq on 5/24/18.
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> left = findLeft(root, target);
        Deque<TreeNode> right = findRight(root, target);
        Deque<Integer> result = new LinkedList<>();
        Set<TreeNode> removedSet = new HashSet<>();
        while (result.size() < k) {
            while (!left.isEmpty() && removedSet.contains(left.peekLast())) left.removeLast();
            while (!right.isEmpty() && removedSet.contains(right.peekLast())) right.removeLast();
            TreeNode node = !left.isEmpty() ? left.peekLast() : null;
            if (node == null || (!right.isEmpty() && ((double) (right.peekLast().val) - target) < target - node.val))
                node = right.peekLast();
            removedSet.add(node);
            System.out.println("This is node " + node.val);
            if (node.val < target) {
                result.addFirst(node.val);
                left.removeLast();
                if (node.left != null) addMore(left, node.left, 0);
            } else {
                result.addLast(node.val);
                right.removeLast();
                if (node.right != null) addMore(right, node.right, 1);
            }
        }//end while
        return new ArrayList<>(result);
    }

    private void addMore(Deque<TreeNode> stack, TreeNode node, int direction) {
        while (node != null) {
            stack.addLast(node);
            if (direction == 0) node = node.right;
            else node = node.left;
        }
    }

    private Deque<TreeNode> findLeft(TreeNode root, double target) {
        TreeNode resultNode = null, node = root;
        Deque<TreeNode> result = new LinkedList<>();
        while (node != null) {
            result.add(node);
            if (node.val <= target) {
                resultNode = node;
                node = node.right;
            } else {
                node = node.left;
            }
        }//end while
        while (!result.isEmpty() && result.peekLast() != resultNode) result.removeLast();
        return result;
    }

    private Deque<TreeNode> findRight(TreeNode root, double target) {
        TreeNode resultNode = null, node = root;
        Deque<TreeNode> result = new LinkedList<>();
        while (node != null) {
            result.add(node);
            if (node.val > target) {
                resultNode = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }//end while
        while (!result.isEmpty() && result.peekLast() != resultNode) result.removeLast();
        return result;
    }

}
