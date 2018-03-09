package programming.leetcode;

public class LongestUnivaluePath {
    class NodeResult {
        public int result, single;

        public NodeResult(int result, int single) {
            this.result = result;
            this.single = single;
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        NodeResult node = visit(root);
        return node.result > 0 ? node.result - 1 : 0;
    }

    private NodeResult visit(TreeNode node) {
        if (node == null) return new NodeResult(0, 0);
        int result = 1;
        int single = 1;
        NodeResult left = visit(node.left);
        NodeResult right = visit(node.right);
        if (node.left != null && node.left.val == node.val) {
            result += left.single;
            single = left.single + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            result += right.single;
            single = Math.max(single, right.single + 1);
        }
        result = Math.max(result, left.result);
        result = Math.max(result, right.result);
        return new NodeResult(result, single);
    }

}
