package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchSticksToSquare {
    public boolean checkSplit(int sum, int current, List<Integer> nums) {
        int n = nums.size();
        int temp = 0;
        for (int i = 0; (1 << i) <= current; i++) {
            int x = current >> i;
            if (((current >> i) & 1) == 1) temp += nums.get(i);
        }
        return temp == sum;
    }


    public boolean makesquare(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;
        List<Integer> numsList = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            numsList.add(num);
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int halfSum = sum / 2;
        if (halfSum % 2 == 1) return false;
        int quarterSum = halfSum / 2;
        for (int i = 1; i < 1 << n; i++) {
            if (checkSplit(halfSum, i, numsList)) {
                List<Integer> halfNum1 = new ArrayList<>();
                List<Integer> halfNum2 = new ArrayList<>();
                for (int j = 0; 1 << j <= i; j++) {
                    if (((i >> j) & 1) == 1) halfNum1.add(numsList.get(j));
                    else halfNum2.add(numsList.get(j));
                }
                int x = 1;
                int n1 = halfNum1.size();
                while (x < 1 << n1 && !checkSplit(quarterSum, x, halfNum1)) x++;
                if (x < 1 << n1) {
                    int y = 1;
                    int n2 = halfNum2.size();
                    while (y < 1 << n2 && !checkSplit(quarterSum, y, halfNum2)) y++;
                    if (y < 1 << n2) return true;
                }
            }
        }
        return false;
    }
}
