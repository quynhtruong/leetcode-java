package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> digitList = new ArrayList<>();
        for (int digit : digits) digitList.add(digit);
        int carry = 1;
        for (int i = digitList.size() - 1; i >= 0; i--) {
            int value = (digitList.get(i) + carry) % 10;
            carry = (digitList.get(i) + carry) / 10;
            digitList.set(i, value);
        }
        if (carry > 0) {
            digitList.add(0, carry);
        }
        int[] result = new int[digitList.size()];
        for (int i = 0; i < digitList.size(); i++) result[i] = digitList.get(i);
        return result;
    }

}
