package programming.leetcode;

import java.util.TreeMap;

/**
 * Created by truongq on 6/20/18.
 */
public class SlidingWindowMedian {
	class Tree {
		public TreeMap<Integer, Integer> data;
		public int size;

		public Tree() {
			this.data = new TreeMap<>();
			this.size = 0;
		}

		public int getMin() {
			return data.firstKey();
		}

		public int getMax() {
			return data.lastKey();
		}

		public void remove(int key) {
			Integer count = data.get(key);
			count--;
			if (count == 0) data.remove(key);
			else
				data.put(key, count);
			size--;
		}

		public void add(int key) {
			Integer count = data.get(key) == null ? 0 : data.get(key);
			data.put(key, count + 1);
			size++;
		}

		public boolean contains(int key) {
			return data.containsKey(key);
		}
	}


	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		double[] result = new double[n - k + 1];
		Tree left = new Tree(), right = new Tree();
		for (int i = 0; i < k; i++) {
			left.add(nums[i]);
			int max = left.getMax();
			left.remove(max);
			right.add(max);
			if (right.size > left.size + 1) {
				int min = right.getMin();
				right.remove(min);
				left.add(min);
			}
		}//end for i
		for (int i = 0; i <= n - k; i++) {
			result[i] = right.size > left.size ? right.getMin() : (double) (left.getMax() + right.getMin()) / 2;
			if (left.contains(nums[i])) {
				left.remove(nums[i]);
			} else {
				right.remove(nums[i]);
			}
			if (i + k < n) {
				left.add(nums[i + k]);
				int max = left.getMax();
				left.remove(max);
				right.add(max);
				if (right.size > left.size + 1) {
					int min = right.getMin();
					right.remove(min);
					left.add(min);
				}
			}
		}//end for i
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMedian solution = new SlidingWindowMedian();
		double[] result = solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
		for(double value: result) System.out.println(value);
	}

}
