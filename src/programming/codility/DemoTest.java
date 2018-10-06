package programming.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by truongq on 8/2/18.
 */
public class DemoTest {
	public int solution(int[] A) {
		int n = A.length;
		Set<Integer> valueSet = new HashSet<>();
		for(int num: A) valueSet.add(num);
		for(int i  = 1;i <= n + 1; i++) {
			if (!valueSet.contains(i)) return i;
		}
		return n + 1;
	}
}
