package programming.leetcode;

public class SortTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        if (n == 0) return nums;
        if (a > 0 || (a == 0 && b > 0)) {
            return populateFromMin(nums, a, b, c);
        } else {
            return populateFromMax(nums, a, b, c);
        }
    }

    private int[] populateFromMin(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (getF(a, b, c, nums[i]) < getF(a, b, c, nums[index])) index = i;
        }//end for i
        int[] result = new int[n];
        int count = 0, start = index - 1, end = index + 1;
        result[count] = getF(a, b, c, nums[index]);
        while (start >= 0 && end < n) {
            if (getF(a, b, c, nums[start]) < getF(a, b, c, nums[end])) {
                result[++count] = getF(a, b, c, nums[start--]);
            } else {
                result[++count] = getF(a, b, c, nums[end++]);
            }
        }//end while looop
        while (start >= 0) result[++count] = getF(a, b, c, nums[start--]);
        while (end < n) result[++count] = getF(a, b, c, nums[end++]);
        return result;
    }

    private int[] populateFromMax(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (getF(a, b, c, nums[i]) > getF(a, b, c, nums[index])) index = i;
        }//end for i
        int[] result = new int[n];
        int count = -1, start = 0, end = n - 1;
        while (start < index && end > index) {
            if (getF(a, b, c, nums[start]) < getF(a, b, c, nums[end])) {
                result[++count] = getF(a, b, c, nums[start++]);
            } else {
                result[++count] = getF(a, b, c, nums[end--]);
            }
        }//end while looop
        while (start < index) result[++count] = getF(a, b, c, nums[start++]);
        while (end > index) result[++count] = getF(a, b, c, nums[end--]);
        result[++count] = getF(a, b, c, nums[index]);
        return result;
    }

    private int getF(int a, int b, int c, int num) {
        return a * num * num + b * num + c;
    }

}
