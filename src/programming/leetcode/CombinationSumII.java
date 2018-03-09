package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by quuynh on 15/06/17.
 */
public class CombinationSumII {
    class TrieNode {
        int value;
        boolean isLeaf = false;
        List<TrieNode> children = new ArrayList<>();

        public TrieNode(int value) {
            this.value = value;
        }

        public TrieNode find(int value) {
            for (TrieNode node : children) if (node.value == value) return node;
            return null;
        }
    }

    TrieNode root = new TrieNode(-1);

    private boolean find(List<Integer> temp) {
        TrieNode node = root;
        boolean result = true;
        for (Integer value : temp) {
            TrieNode child = node.find(value);
            if (child == null) {
                result = false;
                child = new TrieNode(value);
                node.children.add(child);
            }
            node = child;
        }
        if (result) result = node.isLeaf;
        node.isLeaf = true;
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer>[] traceList;

    void traceBack(Integer x, List<Integer> temp, int[] candidates) {
        if (x == 0) {
            List<Integer> newResult = new ArrayList<>();
            for (int i = temp.size() - 1; i >= 0; i--) newResult.add(candidates[temp.get(i)]);
            if (!find(newResult)) result.add(newResult);
        } else {
            List<Integer> traceX = traceList[x];
            for (Integer trace : traceX) {
                if (temp.isEmpty() || temp.get(temp.size() - 1) > trace) {
                    temp.add(trace);
                    traceBack(x - candidates[trace], temp, candidates);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traceList = new ArrayList[target + 1];
        for (int i = 0; i <= target; i++) traceList[i] = new ArrayList<>();
        traceList[0].add(0);
        for (int j = 0; j < candidates.length; j++) {
            for (int i = target; i >= candidates[j]; i--)
                if (!traceList[i - candidates[j]].isEmpty()) {
                    traceList[i].add(j);
                }
        }
        for (int i = 0; i <= target; i++) System.out.println(traceList[i]);
        List<Integer> temp = new ArrayList<>();
        traceBack(target, temp, candidates);
        return result;
    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        int[] nums = {1, 1, 2, 2, 2};
        List<List<Integer>> result = solution.combinationSum2(nums, 6);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
