package programming.codility;

/**
 * Created by truongq on 8/2/18.
 */
public class DecimalRepresentation {
	public int solution(int A, int B) {
		StringBuilder sa = new StringBuilder(String.valueOf(A));
		sa.reverse();
		StringBuilder sb = new StringBuilder(String.valueOf(B));
		sb.reverse();
		StringBuilder result = new StringBuilder();
		while(sa.length() > 0 && sb.length() > 0) {
			result.append(sa.charAt(sa.length() - 1)).append(sb.charAt(sb.length() - 1));
			if (Long.parseLong(result.toString()) > 100000000) return  -1;
			sa.deleteCharAt(sa.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}

		while(sa.length() > 0) {
			result.append(sa.charAt(sa.length() - 1));
			if (Long.parseLong(result.toString()) > 100000000) return  -1;
			sa.deleteCharAt(sa.length() - 1);
		}

		while(sb.length() > 0) {
			result.append(sb.charAt(sb.length() - 1));
			if (Long.parseLong(result.toString()) > 100000000) return  -1;
			sb.deleteCharAt(sb.length() - 1);
		}
		return Integer.parseInt(result.toString());
	}

	public static void main(String[] args) {
		DecimalRepresentation decimalRepresentation = new DecimalRepresentation();
		System.out.println(decimalRepresentation.solution(12, 56));
		System.out.println(decimalRepresentation.solution(56, 12));
		System.out.println(decimalRepresentation.solution(12345, 678));
		System.out.println(decimalRepresentation.solution(123, 67890));
		System.out.println(decimalRepresentation.solution(1234, 0));
		System.out.println(decimalRepresentation.solution(10000000, 0));
		System.out.println(decimalRepresentation.solution(10000000, 1));
	}
}
