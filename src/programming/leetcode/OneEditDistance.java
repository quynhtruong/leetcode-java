package programming.leetcode;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) return false;
        StringBuilder ss = new StringBuilder(s);
        StringBuilder st = new StringBuilder(t);
        for (int i = 0; i < m && i < n; i++) {
            if (ss.charAt(i) != st.charAt(i)) {
                if (m == n) {
                    return ss.substring(i + 1).equals(st.substring(i + 1));
                } else {
                    if (m < n) ss.insert(i, st.charAt(i));
                    else st.insert(i, ss.charAt(i));
                    return ss.toString().equals(st.toString());
                }
            }
        }//end for i
        return true;
    }
}
