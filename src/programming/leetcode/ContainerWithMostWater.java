package programming.leetcode;

/**
 * Created by quuynh on 06/06/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, result = 0;
        while (left <= right) {
            int minHeight = Math.min(height[left], height[right]);
            result = Math.max(result, minHeight * (right - left));
            if (height[left] == minHeight) {
                while (left < n && height[left] <= minHeight) left++;
            } else {
                while (right >= 0 && height[right] <= minHeight) right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
    }
}
