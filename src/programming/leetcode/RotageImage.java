package programming.leetcode;

import java.util.Arrays;

/**
 * Created by quuynh on 15/06/17.
 */
public class RotageImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int first = 0; first < n / 2; first++) {
            int last = n - first - 1;
            //rotate from (first,first) to (last,last)
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int temp = matrix[first][first+offset];
                matrix[first][first + offset] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[first + offset][last];
                matrix[first + offset][last] = temp;
            }
        }
    }
}
