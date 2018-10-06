package programming.leetcode;

/**
 * Created by truongq on 6/17/18.
 */
public class SentenceScreenFitting {
	class Node {
		public int val, next;

		public Node(int val, int next) {
			this.val = val;
			this.next = next;
		}
	}

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int n = sentence.length;
		Node[][] f = new Node[cols + 1][n];
		int[] total = new int[n];
		total[n - 1] = sentence[n - 1].length();
		for (int i = n - 2; i >= 0; i--) total[i] = total[i + 1] + sentence[i].length() + 1;

		for (int i = 0; i <= cols; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (i < sentence[j].length()) {
					f[i][j] = new Node(0, j);
				} else {
					if (i >= total[j]) {
						int remain = i - total[j];
						if (remain > 0) {
							f[i][j] = new Node(f[remain - 1][0].val + 1, f[remain - 1][0].next);
						} else {
							f[i][j] = new Node(1, 0);
						}
					} else {
						int u = j, sum = sentence[j].length();
						while (u < n - 1 && (sum + sentence[u + 1].length() + 1) <= i) {
							u++;
							sum += (sentence[u].length() + 1);
						}
						int remain = i - sum;
						if (remain > 0) {
							f[i][j] = new Node(f[remain - 1][u + 1].val, f[remain - 1][u + 1].next);
						} else {
							f[i][j] = new Node(0, u + 1);
						}
					}
				}
//				System.out.println(i + " " + j + " " + sentence[j] + " " + f[i][j].val + " " + f[i][j].next+" "+sentence[f[i][j].next]);
			}
		}//end for i
		int result = 0, next = 0;
		for (int i = 0; i < rows; i++) {
			//System.out.println(f[cols][next] + " " + next + " " + sentence[next]);
			result += f[cols][next].val;
			next = f[cols][next].next;
		}
		return result;
	}

	public static void main(String[] args) {
		SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
		String[] input = new String[]{"a", "bcd", "e"};
		System.out.println(sentenceScreenFitting.wordsTyping(input, 3, 6));
	}
}
