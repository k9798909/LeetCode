package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums. A subsequence of nums is called a square
 * streak if:
 * 
 * The length of the subsequence is at least 2, and 
 * 
 * after sorting the subsequence, each element (except the first element) is the square of the
 * previous number. Return the length of the longest square streak in nums, or
 * 
 * return -1 if there is no square streak.
 * 
 * A subsequence is an array that can be derived from another array by deleting
 * some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,6,16,8,2] 
 * Output: 3 
 * Explanation: Choose the subsequence [4,16,2]. 
 * 
 * After sorting it, it becomes [2,4,16]. 
 * - 4 = 2 * 2. 
 * - 16 = 4 * 4.
 * Therefore, [4,16,2] is a square streak. 
 * 
 * It can be shown that every subsequence of length 4 is not a square streak. Example 2:
 * 
 * Input: nums = [2,3,5,6,7] Output: -1 Explanation: There is no square streak
 * in nums so return -1.
 */
public class LongestSquareStreakInAnArray2501 {
	
	//HashMap
	public int longestSquareStreak(int[] nums) {
		Arrays.sort(nums);
		Map<Integer,Integer> map = new HashMap<>();
		int maxCnt = -1;
		for (int i = 0; i < nums.length; i++) {
			int square = nums[i] * nums[i];
			
			if (map.containsKey(nums[i])) {
				int cnt = map.get(nums[i]) + 1;
				map.put(square, cnt);
				
				if (maxCnt < cnt) {
					maxCnt = cnt;
				}
			} else {
				map.put(square, 1);
			}
		}
		
		return maxCnt;
	}
	
	
	
	// dp
	public int longestSquareStreakDp(int[] nums) {
		int[] dp = new int[100000 + 1];//num最大限制是100000

		for (int i = 0; i < nums.length; i++) {
			dp[nums[i]] = 1;
		}
		
		//i > 2 是因為nums最小是2
		int maxCnt = -1;
		for (int i = 100000; i > 2; i--) {
			if (dp[i] == 0) {
				continue;
			}

			double sqrt = Math.sqrt(i);

			// 沒辦法開根號以及開完根號的數字不存在nums裡
			if (sqrt % 1.0 > 0 || dp[(int) sqrt] == 0) {
				continue;
			}

			dp[(int) sqrt] += dp[i];
			maxCnt = Math.max(dp[(int) sqrt], maxCnt);
		}

		return maxCnt == 1 ? -1 : maxCnt;
	}
}
