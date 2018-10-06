package programming.leetcode;

/**
 * Created by truongq on 6/24/18.
 */
public class MirrorReflection {
	public int mirrorReflection(int p, int q) {
		if (q == 0) return 0;
		int x = p / q;
		if (x % 2 == 0) return 2;
		return 1;
	}
}
