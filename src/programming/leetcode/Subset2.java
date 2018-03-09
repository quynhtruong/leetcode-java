package programming.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 11/06/17.
 */
public class Subset2 {
    class TrieNode {
        int val;
        boolean isLeaf;
        List<TrieNode> children;

        public TrieNode(int val) {
            this.val = val;
            this.isLeaf = false;
            this.children = new ArrayList<>();
        }

        public TrieNode find(int val) {
            for (TrieNode node : children) if (node.val == val) return node;
            return null;
        }

        public void addChild(TrieNode node) {
            this.children.add(node);
        }
    }

    private TrieNode root = new TrieNode(-1);

    private boolean isExisted(List<Integer> nums) {
        TrieNode node = root;
        for (Integer num : nums) {
            TrieNode childNode = node.find(num);
            if (childNode == null) return false;
            node = childNode;
        }
        return node.isLeaf;
    }

    private void add(List<Integer> nums) {
        TrieNode node = root;
        for (Integer num : nums) {
            TrieNode childNode = node.find(num);
            if (childNode == null) {
                childNode = new TrieNode(num);
                node.addChild(childNode);
            }
            node = childNode;
        }
        node.isLeaf = true;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> tempNums = new ArrayList<>();
            for (int j = 0; j < n; j++) if (((i >> j) & 1) == 1) tempNums.add(nums[j]);
            if (!isExisted(tempNums)) {
                add(tempNums);
                result.add(tempNums);
            }
        }
        return result;
    }
}
