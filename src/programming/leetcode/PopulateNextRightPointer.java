package programming.leetcode;


public class PopulateNextRightPointer {
    class TreeLinkNode {
        int val;
        public TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) return;
            populate(root, root.left);
            populate(root, root.right);
        }

        private void populate(TreeLinkNode parent, TreeLinkNode child) {
            if (child == null) return;
            if (child == parent.left && parent.right != null) {
                child.next = parent.right;
            } else {
                TreeLinkNode nextParent = parent.next;
                while (nextParent != null && nextParent.next == null && nextParent.right == null)
                    nextParent = nextParent.next;
                if (nextParent != null) {
                    child.next = nextParent.left != null ? nextParent.left : nextParent.right;
                }
            }
            populate(child, child.left);
            populate(child, child.right);
        }
    }

}
