package programming.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by truongq on 6/24/18.
 */
public class ScoreParenthese {
	public int scoreOfParentheses(String S) {
		int n = S.length();
		if (n <= 1) return 0;
		int[][] f = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
				f[i][i + 1] = 1;
			}
		}

		for (int j = 2; j < n; j++) {
			for (int i = j - 2; i >= 0; i--) if (S.charAt(i) == '(' && S.charAt(j) == ')') {
				if (f[i + 1][j - 1] > 0) {
					f[i][j] = 2 * f[i + 1][j - 1];
				} else {
					for (int u = i + 1; u < j; u++) if (f[i][u] > 0 && f[u + 1][j] > 0) f[i][j] = f[i][u] + f[u + 1][j];
				}
			}
		}
		return f[0][n - 1];
	}

	public static void main(String[] args) {
		ScoreParenthese solution = new ScoreParenthese();
		System.out.println(solution.scoreOfParentheses("()"));
		System.out.println(solution.scoreOfParentheses("(())"));
		System.out.println(solution.scoreOfParentheses("(()(()))"));
		System.out.println(solution.scoreOfParentheses("()()()"));
	}
}

