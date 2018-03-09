package programming.leetcode;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class NextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        connect(root, root.left);
        connect(root, root.right);
    }

    public void connect(TreeLinkNode parent, TreeLinkNode child) {
        if (child == null) return;
        if (child == parent.left) {
            child.next = parent.right;
        } else {
            if (parent.next != null) {
                child.next = parent.next.left;
            }
        }
        connect(child, child.left);
        connect(child, child.right);
    }
}
