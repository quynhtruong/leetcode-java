package programming.leetcode;

/**
 * Created by truongq on 5/31/18.
 */
public class HouseRobberIII {
	class NodeResult {
		public int inc,exc;
		public NodeResult(int inc, int exc) {
			this.inc = inc;
			this.exc = exc;
		}
	}

	public int rob(TreeNode root) {
		if (root == null) return 0;
		NodeResult result = visit(root);
		return Math.max(result.inc, result.exc);
	}

	public NodeResult visit(TreeNode node) {
		NodeResult result = new NodeResult(0, 0);
		if	(node == null) return result;
		NodeResult left = visit(node.left);
		NodeResult right = visit(node.right);
		result.inc = node.val + left.exc + right.exc;
		result.exc = Math.max(left.inc, left.exc) + Math.max(right.inc, right.exc);
		return result;
	}

}
