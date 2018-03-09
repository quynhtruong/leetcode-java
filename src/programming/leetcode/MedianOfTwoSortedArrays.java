package programming.leetcode;

import static java.lang.Math.min;

/**
 * Created by quuynh on 26/05/17.
 */
public class MedianOfTwoSortedArrays {
    private int findMedian(int[] nums1, int[] nums2, int m, int n, int l1, int l2, int k) {
        if (m - l1 > n - l2)
            return findMedian(nums2, nums1, n, m, l2, l1, k);
        if (l1 >= m) return nums2[l2 + k - 1];
        if (k == 1) return min(nums1[l1], nums2[l2]);
        int mid = (k / 2);
        mid = min(mid, m - l1);
        if (nums1[l1 + mid - 1] > nums2[l2 + mid - 1]) {
            return findMedian(nums1, nums2, m, n, l1, l2 + mid, k - mid);
        } else {
            return findMedian(nums1, nums2, m, n, l1 + mid, l2, k - mid);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            k++;
            return (double) findMedian(nums1, nums2, m, n, 0, 0, k);
        } else {
            return ((double) findMedian(nums1, nums2, m, n, 0, 0, k) + findMedian(nums1, nums2, m, n, 0, 0, k+1))/2;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] num1 = {1, 4};
        int[] num2 = {2,3};
        System.out.println(solution.findMedianSortedArrays(num1, num2));
    }
}
