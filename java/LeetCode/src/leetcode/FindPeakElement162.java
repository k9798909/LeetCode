package leetcode;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * [1,2,3,4,3]
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int mid = nums.length / 2;
        int right = nums.length - 1;

        while (left != mid || right != mid) {
            while (left != mid && nums[left] <= nums[mid]) {
                left++;
            }

            while (left != mid && nums[left] > nums[mid]) {
                mid--;
            }

            while (right != mid && nums[right] <= nums[mid]) {
                right--;
            }

            while (right != mid && nums[right] > nums[mid]) {
                mid++;
            }
        }

        return mid;
    }
}
