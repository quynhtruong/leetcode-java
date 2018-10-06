package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 6/10/18.
 */
public class MaximizeDistanceToClosestPerson {
	public int maxDistToClosest(int[] seats) {
		int n = seats.length;
		List<Integer> person = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if (seats[i] == 1) person.add(i);
		}
		int result = Math.max(person.get(0), n - 1 - person.get(person.size() -1));
		for(int i = 1; i < person.size(); i++) {
			result = Math.max(result, (person.get(i) - person.get(i-1))/2);
		}
		return result;
	}
}
