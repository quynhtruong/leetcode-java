package programming.leetcode;

import java.util.Arrays;

/**
 * Created by truongq on 8/5/18.
 */
public class NumberOfBoats {

	public static int numRescueBoats(int[] people, int limit) {
		int n = people.length;
		Arrays.sort(people);
		boolean[] free = new boolean[n];
		Arrays.fill(free, true);
		int result = 0, last = n - 1;
		for(int i = 0; i < n; i++) {
			if (free[i]) {
				result++;
				while (last > i && people[last] > limit - people[i]) last--;
				if (last > i) {
					free[last] = false;
					last--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		//System.out.println(numRescueBoats(new int[]{1,2}, 3));
		//System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
		//System.out.println(numRescueBoats(new int[]{3,2,3,2,2}, 6));
		String[] tokens = "a2345678999999999999999".split("\\d");
		System.out.println(tokens.length);
		for(String token: tokens) {
			System.out.println(token);
		}
	}
}

