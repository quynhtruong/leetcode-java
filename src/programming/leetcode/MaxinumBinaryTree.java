package programming.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class MaxinumBinaryTree {
    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = buildTree(nums, start, maxIndex - 1);
        node.right = buildTree(nums, maxIndex + 1, end);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        return buildTree(nums, 0, n - 1);
    }
}