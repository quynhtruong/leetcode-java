package programming.codility;

/**
 * Created by truongq on 8/2/18.
 */
public class CharFrequence {
	String solution(String S) {
		int[] occurrences = new int[26];
		for (char ch : S.toCharArray()) {
			occurrences[ch - 'a']++;
		}

		char best_char = 'a';
		int  best_res  = occurrences[0];

		for (int i = 1; i < 26; i++) {
			if (occurrences[i] > best_res) {
				best_char = (char)((int)'a' + i);
				best_res  = occurrences[i];
			}
		}
		return Character.toString(best_char);
	}

	public static void main(String[] args) {
		CharFrequence charFrequence = new CharFrequence();
		System.out.println(charFrequence.solution("ccaa"));
	}
}
