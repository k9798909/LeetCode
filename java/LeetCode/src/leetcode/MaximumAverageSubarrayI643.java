package leetcode;

/**
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value.
 * <p>
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 */
public class MaximumAverageSubarrayI643 {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        if (nums.length == k) {
            return sum / k;
        }

        double maxSum = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum += nums[i + k];
            sum -= nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum / k;
    }

}
