package programming.leetcode;

import java.util.Arrays;

public class ReconstructOriginalDigitFromEnglish {
    public String originalDigits(String s) {
        int n = s.length();
        int[] count = new int[257];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }
        int[] result = new int[10];
        result[0] = count['z'];
        result[6] = count['x'];
        result[2] = count['w'];
        result[8] = count['g'];
        result[3] = count['t'] - result[2] - result[8];
        result[7] = count['s'] - result[6];
        result[5] = count['v'] - result[7];
        result[4] = count['f'] - result[5];
        result[3] = count['h'] - result[8];
        result[1] = count['o'] - result[0] - result[2] - result[4];
        result[9] = count['i'] - result[5] - result[6] - result[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < result[i]; j++) {
                sb.append((char) (i + '0'));
            }
        }
        return sb.toString();
    }
}
