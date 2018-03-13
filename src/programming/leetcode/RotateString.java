package programming.leetcode;

public class RotateString {
    public boolean rotateString(String A, String B) {
        int n = A.length();
        StringBuilder sb  = new StringBuilder(A);
        for(int i = 0; i < n; i++) {
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if (sb.toString().equals(B)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde","cdeba"));
    }
}
