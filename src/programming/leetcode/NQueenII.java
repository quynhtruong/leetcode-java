package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quuynh on 07/07/17.
 */
public class NQueenII {
    private int result = 0;

    private boolean isValid(List<Integer> tempPos, int newEntry) {
        int len = tempPos.size();
        for (int i = 0; i < len; i++) {
            if (Integer.compare(Math.abs(i - len), Math.abs(tempPos.get(i) - newEntry)) == 0) return false;
        }
        return true;
    }

    private void visit(int n, List<Integer> tempPos, boolean[] free) {
        for (int i = 0; i < n; i++)
            if (free[i] && isValid(tempPos, i)) {
                free[i] = false;
                tempPos.add(i);
                if (tempPos.size() == n) {
                    result++;
                } else {
                    visit(n, tempPos, free);
                }
                free[i] = true;
                tempPos.remove(tempPos.size() - 1);
            }
    }

    public int totalNQueens(int n) {
        List<Integer> tempPos = new ArrayList<>();
        boolean[] free = new boolean[n];
        Arrays.fill(free, true);
        visit(n, tempPos, free);
        return result;
    }
}
