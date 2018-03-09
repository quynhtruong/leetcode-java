package programming.leetcode;

import java.util.*;

/**
 * Created by quuynh on 15/06/17.
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer>[] traceList;

    void visit(Integer x, List<Integer> currentResult) {
        if (x == 0) {
            List<Integer> newResult = new ArrayList<>(currentResult);
            Collections.reverse(newResult);
            result.add(newResult);
        } else {
            for (Integer trace : traceList[x])
                if (currentResult.isEmpty() || currentResult.get(currentResult.size() - 1) >= trace) {
                    currentResult.add(trace);
                    visit(x - trace, currentResult);
                    currentResult.remove(currentResult.size() - 1);
                }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traceList = new ArrayList[target + 1];
        for (int i = 0; i <= target; i++) traceList[i] = new ArrayList<>();
        traceList[0].add(0);
        for (int i = 1; i <= target; i++)
            for (Integer j : candidates) if (i >= j && !traceList[i - j].isEmpty()) traceList[i].add(j);
        List<Integer> currentResult = new ArrayList<>();
        visit(target, currentResult);
        return result;
    }
}
