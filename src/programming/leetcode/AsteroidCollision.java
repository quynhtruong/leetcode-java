package programming.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] arr) {
		int n = arr.length;
		boolean[] destroy = new boolean[n];
		Arrays.fill(destroy, false);
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				stack.addLast(i);
			} else {
				while (!stack.isEmpty() && arr[stack.peekLast()] < Math.abs(arr[i])) {
					destroy[stack.removeLast()] = true;
				}
				if (!stack.isEmpty()) {
					destroy[i] = true;
					if (arr[stack.peekLast()] == arr[i]) {
						destroy[stack.removeLast()] = true;
					}
				}
			}
		} //end for i
		int count = 0;
		for (int i = 0; i < n; i++) if (!destroy[i]) count++;
		int[] result = new int[count];
		count = 0;
		for (int i = 0; i < n; i++) {
			if (!destroy[i]) result[count++] = i;
		}
		return result;
	}

}
