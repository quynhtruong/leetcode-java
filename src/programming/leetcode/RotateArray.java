package programming.leetcode;

public class RotateArray {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
