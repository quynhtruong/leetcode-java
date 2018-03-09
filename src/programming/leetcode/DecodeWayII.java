package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 25/07/17.
 */
public class DecodeWayII {
    public int numDecodings(String s) {
        s = "$" + s;
        int n = s.length();
        long[][] f = new long[n][10];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], 0);
        long[] cumulative = new long[n];
        Arrays.fill(cumulative, 0);
        cumulative[0] = 1;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '*') {
                int j = ch - '0';
                if (j > 0) f[i][j] = cumulative[i - 1];
                char pCh = s.charAt(i - 1);
                if (pCh >= '1' && pCh <= '2') {
                    if (Integer.parseInt("" + pCh + j) <= 26) f[i][j] += cumulative[i - 2];
                } else if (pCh == '*') {
                    if (Integer.parseInt("" + 1 + j) <= 26) f[i][j] += cumulative[i - 2];
                    if (Integer.parseInt("" + 2 + j) <= 26) f[i][j] += cumulative[i - 2];
                }
            } else { //ch == '*'
                for (int j = 1; j <= 9; j++) {
                    f[i][j] += cumulative[i - 1];
                    char pCh = s.charAt(i - 1);
                    if (pCh >= '1' && pCh <= '2') {
                        if (Integer.parseInt("" + pCh + j) <= 26) f[i][j] += cumulative[i - 2];
                    } else if (pCh == '*') {
                        if (Integer.parseInt("" + 1 + j) <= 26) f[i][j] += cumulative[i - 2];
                        if (Integer.parseInt("" + 2 + j) <= 26) f[i][j] += cumulative[i - 2];
                    }
                }
            }
            for (int j = 0; j <= 9; j++) cumulative[i] = (cumulative[i] + f[i][j]) % 1000000007;
        }
        return (int) cumulative[n - 1];
    }

    public int numDecodings2(String s) {
        s = "$" + s;
        int n = s.length();
        long[][] f = new long[n][10];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], 0);
        long[] culmulative = new long[n];
        Arrays.fill(culmulative, 0);
        culmulative[0] = 1;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = 0; j <= 9; j++) {
                if (ch != '*') {
                    if (ch - '0' != j) f[i][j] = 0;
                    else {
                        if (ch != '0') f[i][j] += culmulative[i - 1];
                        char pCh = s.charAt(i - 1);
                        if (pCh >= '1' && pCh <= '9') {
                            if (Integer.parseInt("" + pCh + ch) <= 26) f[i][j] += culmulative[i - 2];
                        } else if (pCh == '*') {
                            if (Integer.parseInt("" + 1 + ch) <= 26) f[i][j] += culmulative[i - 2];
                            if (Integer.parseInt("" + 2 + ch) <= 26) f[i][j] += culmulative[i - 2];
                        }
                    }
                } else {
                    if (j != 0) f[i][j] += culmulative[i - 1];
                    char pCh = s.charAt(i - 1);
                    if (pCh >= '1' && pCh <= '9') {
                        if (Integer.parseInt("" + pCh + j) <= 26) f[i][j] += culmulative[i - 2];
                    } else if (pCh == '*') {
                        if (Integer.parseInt("" + 1 + j) <= 26) f[i][j] += culmulative[i - 2];
                        if (Integer.parseInt("" + 2 + j) <= 26) f[i][j] += culmulative[i - 2];
                    }
                }
                culmulative[i] = (culmulative[i] + f[i][j]) % 1000000007;
            }
        }
        return (int) culmulative[n - 1];
    }

}
