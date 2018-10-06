package programming.codility;

/**
 * Created by truongq on 10/6/18.
 */
public class CombinationSum {
	public static long calculateSum(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		long a = 1, b = 2, c = 4;
		for(int i = 4; i <= n; i++) {
			long next = a + b + c;
			a = b;
			b = c;
			c = next;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(calculateSum(4));
		System.out.println(calculateSum(7));
		System.out.println(calculateSum(50));
		System.out.println(calculateSum(12));
		System.out.println(calculateSum(21));
		System.out.println(calculateSum(6));
	}
}
