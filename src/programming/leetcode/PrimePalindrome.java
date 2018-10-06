package programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by truongq on 8/31/18.
 */
public class PrimePalindrome {
	private Integer result = null;

	public int primePalindrome(int n) {
		if (n <= 2) return 2;
		int nLen = String.valueOf(n).length();
		for(int len = nLen; len < 10; len++) {
			tryLen(n, len);
			if (result != null) return result;
		}
		return -1;
	}

	private void tryLen(int n, int len) {
		int[] digit = new int[len];
		visit(digit, 0, len - 1, n);
	}

	private void visit(int[] digit, int start, int end, int n) {
		if (result != null) return;
		for(int i = 0; i < 10; i++) {
			digit[start] = i;
			digit[end] = i;
			if (start == end || start == end - 1) {
				if (check(digit, n)) {
					return;
				}
			} else {
				visit(digit, start + 1, end - 1, n);
			}
		}
	}

	private boolean check(int[] digit, int n) {
		int temp = 0;
		for(int value: digit) temp = temp * 10 + value;
		if (temp < n) return false;
		for(int i = 2; i * i <= temp; i++) {
			if (temp % i == 0) return false;
		}
		result = temp;
		return true;
	}

}
