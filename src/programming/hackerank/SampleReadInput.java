package programming.hackerank;

import java.io.*;
import java.util.Scanner;

/**
 * Created by truongq on 6/15/18.
 */
public class SampleReadInput {
	public static void main(String[] args) throws IOException {
//		Scanner scanner  = new Scanner(new File("/Users/truongq/Desktop/Study/programming/leetcode-java/src/programming/hackerank/test.txt"));
		BufferedReader reader = new BufferedReader(new FileReader("/Users/truongq/Desktop/Study/programming/leetcode-java/src/programming/hackerank/test.txt"));
		String line = null;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}

