package programming.hackerank;

import java.io.*;
import java.util.Scanner;

/**
 * Created by truongq on 6/15/18.
 */
public class TheGridSearch {

	static String gridSearch(String[] G, String[] P) {
		int m = G.length;
		int n = G[0].length();
		int x = P.length;
		int y = P[0].length();
		for(int i = 0; i <= m - x; i++) {
			for (int j = 0; j <= n - y; j++) {
				boolean exist  = true;
				for(int u = 0; u < x; u++) {
					if (!exist) break;
					for(int v = 0; v < y; v ++) {
						if (G[i+u].charAt(j+v) != P[u].charAt(v)) {
							exist = false;
							break;
						}
					}
				}
				if (exist) return "YES";
			}
		}
		return "NO";
	}

	private static Scanner scanner;

	static {
		try {
			scanner = new Scanner(new File("/Users/truongq/Desktop/Study/programming/leetcode-java/src/programming/hackerank/TheGridSearch.inp"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/truongq/Desktop/Study/programming/leetcode-java/src/programming/hackerank/TheGridSearch.out"));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] RC = scanner.nextLine().split(" ");

			int R = Integer.parseInt(RC[0]);

			int C = Integer.parseInt(RC[1]);

			String[] G = new String[R];

			for (int i = 0; i < R; i++) {
				String GItem = scanner.nextLine();
				G[i] = GItem;
			}

			String[] rc = scanner.nextLine().split(" ");

			int r = Integer.parseInt(rc[0]);

			int c = Integer.parseInt(rc[1]);

			String[] P = new String[r];

			for (int i = 0; i < r; i++) {
				String PItem = scanner.nextLine();
				P[i] = PItem;
			}

			String result = gridSearch(G, P);						

			System.out.println(result);
			//bufferedWriter.write(result);
			//bufferedWriter.newLine();
		}

		//bufferedWriter.close();

		scanner.close();
	}
}
