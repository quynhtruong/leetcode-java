package programming.viettel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongq on 6/18/18.
 */
public class MessageSplitter {

	public static List<String> split(String s, int capacity) {
		List<String> result = new ArrayList<>();
		int n = s.length();
		if (n <= capacity) {
			result.add(s);
			return result;
		}
		String[] tokens = s.split(" ");
		int len = tokens.length;

		for (int limitLen = 1; limitLen < capacity; limitLen++) {
			result = tryToFit(tokens, len, capacity, limitLen);
			if (!result.isEmpty()) {
				return result;
			}
		}
		throw new IllegalArgumentException("a word must be shorter than capacity!");
	}

	private static List<String> tryToFit(String[] tokens, int len, int capacity, int limitLen) {
		List<String> result = new ArrayList<>();
		int index = 0;
		while (index < len) {
			int lenOfIndex = String.valueOf(result.size() + 1).length();
			if (lenOfIndex > limitLen) {
				return new ArrayList<>();
			}
			int lenOfPrefix = lenOfIndex + limitLen + 2;
			int remain = capacity - lenOfPrefix;
			if (tokens[index].length() > remain) {
				return new ArrayList<>();
			}
			StringBuilder sb = new StringBuilder(tokens[index++]);
			while (index < len && sb.length() + 1 + tokens[index].length() <= remain) {
				sb.append(" ").append(tokens[index++]);
			}
			result.add(sb.toString());
		}
		for (int i = 0; i < result.size(); i++) {
			result.set(i, (i + 1) + "/" + result.size() + " " + result.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		//List<String> result = split("I can't believe Tweeter now supports chunking my messages, so I don't has to do it myself", 40);
		List<String> result = split("a b c d e a s a e t g h a t d d e t 6", 10);
		for (String token : result) {
			System.out.println(token + " " + token.length());
		}
	}
}
