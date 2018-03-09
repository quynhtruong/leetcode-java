package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubSequence {
    class TrieNode {
        public int value;
        public boolean isLeaf;
        public List<TrieNode> children = new ArrayList<>();

        public TrieNode(int value) {
            this.value = value;
            this.isLeaf = false;
            this.children = new ArrayList<>();
        }

        public TrieNode find(int value) {
            for (TrieNode child : children) {
                if (child.value == value) return child;
            }
            return null;
        }
    }

    public TrieNode root = new TrieNode(-101);
    public List<List<Integer>> result = new ArrayList<>();

    public void visit(int pos, int[] nums, List<Integer> tempResult) {
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] >= tempResult.get(tempResult.size() - 1)) {
                tempResult.add(nums[i]);
                if (tempResult.size() > 2 && !checkExist(tempResult)) {
                    List<Integer> newResult = new ArrayList<>();
                    for (int x = 1; x < tempResult.size(); x++) newResult.add(tempResult.get(x));
                    result.add(newResult);
                }
                visit(i + 1, nums, tempResult);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    public boolean checkExist(List<Integer> temp) {
        TrieNode node = root;
        boolean result = true;
        for (int i = 1; i < temp.size(); i++) {
            TrieNode child = node.find(temp.get(i));
            if (child == null) {
                result = false;
                child = new TrieNode(temp.get(i));
                node.children.add(child);
            }
            node = child;
        }
        if (node.isLeaf) {
            result = true;
        }
        node.isLeaf = true;
        return result;
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<Integer> tempResult = new ArrayList<>();
        tempResult.add(-101);
        visit(0, nums, tempResult);
        return result;
    }

    public static void main(String[] args) {
        IncreasingSubSequence solution = new IncreasingSubSequence();
        int[] nums = new int[]{4, 6, 7, 7};
        List<List<Integer>> result = solution.findSubsequences(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
