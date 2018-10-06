package programming.leetcode;

/**
 * Created by truongq on 6/24/18.
 */
public class BuddyString {
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length()) return false;
		int n = A.length();
		if (n <= 1) return false;
		if (A.equals(B)) {
			int[] count = new int[257];
			for(int i = 0; i < n; i++) {
				count[A.charAt(i)]++;
				if (count[A.charAt(i)] == 2) return true;
			}
		}
		int first = 0, last = n - 1;
		for (int i = 0; i < n; i++) {
			if (A.charAt(i) != B.charAt(i)) {
				first = i;
				break;
			}
		}
		for (int i = n - 1; i > first; i--) {
			if (A.charAt(i) != B.charAt(i)) {
				last = i;
				break;
			}
		}
		char[] arr = A.toCharArray();
		char tmp = arr[first];
		arr[first] = arr[last];
		arr[last] = tmp;
		String newA = String.valueOf(arr);
		return newA.equals(B);
	}

	public static void main(String[] args) {
		BuddyString buddyString = new BuddyString();
		System.out.println(buddyString.buddyStrings("","aa"));
	}
}
