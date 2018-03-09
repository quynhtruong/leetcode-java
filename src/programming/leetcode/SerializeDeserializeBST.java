package programming.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildResult(root, sb);
        return sb.toString();
    }

    private void buildResult(TreeNode node, StringBuilder sb) {
        sb.append(node == null ? "null" : node.val).append(",");
        if (node == null) return;
        buildResult(node.left, sb);
        buildResult(node.right, sb);
    }

    public TreeNode deserialize(String input) {
        Deque<Integer> data = new LinkedList<>();
        int index = 0;
        for (int i = 1; i < input.length(); i++)
            if (input.charAt(i) == ',') {
                String value = input.substring(index, i);
                Integer nodeData = "null".equals(value) ? null : Integer.parseInt(value);
                data.addLast(nodeData);
                index = i + 1;
            }
        return rebuildTree(data);
    }

    public TreeNode rebuildTree(Deque<Integer> data) {
        Integer value = data.removeFirst();
        if (value == null) return null;
        TreeNode node = new TreeNode(value);
        if (!data.isEmpty()) node.left = rebuildTree(data);
        if (!data.isEmpty()) node.right = rebuildTree(data);
        return node;
    }
}
