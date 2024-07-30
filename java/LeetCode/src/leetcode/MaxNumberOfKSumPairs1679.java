package leetcode;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can pick two numbers from the array
 * whose sum equals k and remove them from the array.
 * <p>
 * Return the maximum number of operations you can perform on the array.
 *
 */
public class MaxNumberOfKSumPairs1679 {

    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                result++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
