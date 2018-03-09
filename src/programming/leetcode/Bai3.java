package programming.leetcode;

public class Bai3 {
    static int[] stringSimilarity(String[] inputs) {
        int len = inputs.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = search(inputs[i]);
        }
        return result;
    }

    public static int search(String text) {
        int l = text.length();
        int[] Z = new int[l];
        calculateZArray(text, Z);
        int r = 0;
        for (int i = 1; i < l; ++i) {
            r = r + Z[i];
        }
        return r + l;
    }

    public static void calculateZArray(String s, int Z[]) {
        int n = s.length();
        int L, R, k;
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;
                while (R < n && s.charAt(R - L) == s.charAt(R)) R++;
                Z[i] = R - L;
                R--;
            } else {
                k = i - L;
                if (Z[k] < R - i + 1) Z[i] = Z[k];
                else {
                    L = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R)) R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
