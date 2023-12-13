package leetcode;

/**
 * Given the array of integers nums, you will choose two different indices i and j 
 * of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
public class MaximumProductOfTwoElementsInAnArray1464 {
	public int maxProduct(int[] nums) {
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num1 < num) {
				if (num1 > num2) {
					num2 = num1;
				}
				num1 = num;
			} else if (num > num2) {
				num2 = num;
			}
		}
		return (num1 - 1) * (num2 - 1);
	}
}
