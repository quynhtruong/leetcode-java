package programming.codility;

/**
 * Created by truongq on 5/5/18.
 */
public class BinaryModifycation {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                for (int j = i; j < s.length(); j++) sb.append(s.charAt(j));
                break;
            }
        }
        s = sb.toString();
        int n = s.length();
        if (n == 0) return 0;
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') result++;
            else result += 2;
        }
        return result - 1;
    }

    public static void main(String[] args) {
        BinaryModifycation solution = new BinaryModifycation();
        System.out.println(solution.solution("10000111101111010101010110101010101101010101010111111111"));
    }
}
