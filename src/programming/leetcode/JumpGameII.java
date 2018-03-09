package programming.leetcode;

/**
 * Created by quuynh on 15/06/17.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int[] reach = new int[n + 1];
        reach[0] = nums[0];
        int last = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = last; j <= result; j++)
                if (reach[j] >= i) {
                    last = j;
                    result = Math.max(result, j + 1);
                    reach[j + 1] = Math.max(reach[j + 1], i + nums[i]);
                    break;
                }
        }
        return result;
    }
}
