package programming.leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FindKThSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        if (getCount(nums, 0) >= k) {
            return 0;
        } else {
            int left = 0, right = 1000001;
            while (right - left > 1) {
                int mid = (left + right) / 2;
                int count = getCount(nums, mid);
                if (count >= k) right = mid;
                else left = mid;
            }
            return right;
        }
    }

    private int getCount(int[] nums, int diff) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int left = i, right = n;
            while (right - left > 1) {
                int mid = (left + right) / 2;
                if (nums[mid] <= nums[i] + diff) left = mid;
                else right = mid;
            }
            result += (right - i - 1);
        }//end for i
        return result;
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/truongq/Desktop/Study/programming/leetcode-java/src/programming/leetcode/input.txt"));
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) nums[i] = list.get(i);
        FindKThSmallestPairDistance findKThSmallestPairDistance = new FindKThSmallestPairDistance();
        System.out.println(findKThSmallestPairDistance.smallestDistancePair(nums, 25000000));
    }
}
