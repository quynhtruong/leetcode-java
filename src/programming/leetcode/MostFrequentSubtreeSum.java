package programming.leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public int visit(TreeNode node, Map<Integer, Integer> countMap) {
        if (node == null) return 0;
        int leftSum = visit(node.left, countMap);
        int rightSum = visit(node.right, countMap);
        Integer total = node.val + leftSum + rightSum;
        countMap.put(total, countMap.get(total) == null ? 1 : countMap.get(total) + 1);
        return total;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        visit(root, countMap);
        Integer maxFrequent = 0;
        Integer nFrequent = 0;
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) > maxFrequent) {
                maxFrequent = countMap.get(key);
                nFrequent = 1;
            } else if (countMap.get(key) == maxFrequent) {
                nFrequent += 1;
            }
        }
        int[] result = new int[nFrequent];
        nFrequent = 0;
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == maxFrequent) {
                result[nFrequent++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
    }
}
