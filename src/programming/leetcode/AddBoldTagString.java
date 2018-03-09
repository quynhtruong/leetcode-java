package programming.leetcode;

public class AddBoldTagString {
    public String addBoldTag(String s, String[] dict) {
        int n  = s.length();
        if (n == 0) return "";
        boolean[] bold = new boolean[n];
        for(int i = 0; i < n; i++) {
            for(String word: dict) {
                if (i + word.length() <= n && word.equals(s.substring(i, i + word.length()))) {
                    for(int j = i; j < i + word.length(); j ++) bold[j] = true;
                }
            }
        }//end for i
        StringBuilder result = new StringBuilder();
        if (bold[0]) result.append("<b>");
        result.append(s.charAt(0));
        for(int i = 1; i < n; i++) {
            if (bold[i] && !bold[i - 1]) {
                result.append("<b>");
            } else if (!bold[i] && bold[i-1]) {
                result.append("</b>");
            }
            result.append(s.charAt(i));
        }
        if (bold[n-1]) result.append("</b>");
        return result.toString();
    }

    public static void main(String[] args) {
        Double x = 1.0D;
    }

}
