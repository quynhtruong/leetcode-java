package programming.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by truongq on 8/8/18.
 */
public class SerializeDeserializeNaryTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public String serialize(Node root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		visit(root, sb);
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private void visit(Node node, StringBuilder sb) {
		sb.append(node.val).append("/").append(node.children.size()).append("-");
		for(Node child: node.children) {
			visit(child, sb);
		}
	}

	public Node deserialize(String data) {
		if ("".equals(data)) return null;
		Deque<String> queue = new LinkedList<>();
		for(String token: data.split("-")) {
			queue.addLast(token);
		}
		return build(queue);
	}

	private Node build(Deque<String> queue) {
		String s = queue.removeFirst();
		String[] tokens = s.split("/");
		int val = Integer.parseInt(tokens[0]);
		int nChild = Integer.parseInt(tokens[1]);
		List<Node> children = new ArrayList<>();
		for(int i = 0; i < nChild; i++) {
			children.add(build(queue));
		}//end for i
		return new Node(val, children);
	}

}
