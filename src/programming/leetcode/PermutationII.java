package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 15/06/17.
 */
public class PermutationII {


    class TrieNode {
        public int value;
        public Map<Integer, TrieNode> children;

        public TrieNode(int value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        public TrieNode find(int value) {
            return children.get(value);
        }
    }

    private TrieNode root = new TrieNode(-1);

    private boolean exist(List<Integer> temp) {
        TrieNode node = root;
        for (int num : temp) {
            TrieNode child = node.find(num);
            if (child == null) return false;
            node = child;
        }
        return true;
    }

    private void add(List<Integer> temp) {
        TrieNode node = root;
        for (int num : temp) {
            TrieNode child = node.find(num);
            if (child == null) {
                child = new TrieNode(num);
                node.children.put(num, child);
            }
            node = child;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        build(nums, free, temp);
        return result;
    }

    public void build(int[] nums, boolean[] free, List<Integer> temp) {
        for (int i = 0; i < nums.length; i++) {
            if (free[i]) {
                free[i] = false;
                temp.add(nums[i]);
                if (temp.size() == nums.length) {
                    if (!exist(temp)) {
                        add(temp);
                        List<Integer> newResult = new ArrayList<>();
                        newResult.addAll(temp);
                        result.add(newResult);
                    }
                } else build(nums, free, temp);
                free[i] = true;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationII solution = new PermutationII();
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //private List<List<Integer>> result = new ArrayList<>();
    private boolean[] free;

    private void visit(int[] nums, int n, List<Integer> temp, boolean[] free) {
        for (int i = 0; i < n; i++)
            if (free[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && free[i - 1]) continue;
                free[i] = false;
                temp.add(nums[i]);
                if (temp.size() == n) result.add(new ArrayList<>(temp));
                else visit(nums, n, temp, free);
                free[i] = true;
                temp.remove(temp.size() - 1);
            }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        free = new boolean[n];
        Arrays.fill(free, true);
        List<Integer> temp = new ArrayList<>();
        visit(nums, n, temp, free);
        return result;
    }
}
