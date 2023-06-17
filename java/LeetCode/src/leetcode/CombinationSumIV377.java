package leetcode;

public class CombinationSumIV377 {
	//[1,2] 3
	//dp初始值1，dp[i]代表可以加到此i的數量，例如 i = 1 只有nums[0]可以從i = 0 加到 1 故  dp[i] += dp[i - nums[0]] (因為1加到1要從0加故加上0的數目)
	//i = 2 nums[0] nums[1] 可以加到此數，故dp[i] += dp[i - nums[0]] dp[i] += dp[i - nums[1]] 故 dp[2] = 2;
	//i = 3 nums[0] nums[1] 可以加到此數，故dp[i] += dp[i - nums[0]] dp[i] += dp[i - nums[1]] 故 dp[2] = 2;
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] <= i) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}
}
