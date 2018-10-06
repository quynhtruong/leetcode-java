package programming.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by quuynh on 30/06/17.
 */
public class A132Pattern {
	public boolean find132pattern(int[] nums) {
		int n = nums.length;
		if (n < 3) return false;
		int[] minValue = new int[n];
		minValue[0] = nums[0];
		for (int i = 1; i < n; i++) {
			minValue[i] = Math.min(nums[i], minValue[i - 1]);
		}
		TreeSet<Integer> set = new TreeSet<>();
		set.add(nums[n - 1]);
		for (int i = n - 2; i > 0; i--) {
			if (nums[i] > minValue[i - 1]) {
				Integer higher = set.higher(minValue[i - 1]);
				if (higher != null && higher < nums[i]) {
					return true;
				}
			}
			set.add(nums[i]);
		}
		return false;
	}

}
