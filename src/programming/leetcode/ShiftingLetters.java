package programming.leetcode;

/**
 * Created by truongq on 6/10/18.
 */
public class ShiftingLetters {
	public String shiftingLetters(String s, int[] shifts) {
			int n = s.length();
			int m = shifts.length;
			StringBuilder result = new StringBuilder();
			int[] next = new int[26];
			for(int i = 0; i < 26; i++) next[i] = i + 1;
			next[25] = 0;
			long sum = 0;
			for(int i = m -1; i >= 0; i--) {
				sum += shifts[i];
				long time = sum % 26;
				int current = (s.charAt(i) - 'a');
				for(long j = 0; j < time; j++) current = next[current];
				result.append((char)(current + 'a'));
			}
			result.reverse();
			return result.toString();
	}
}
