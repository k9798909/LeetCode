package leetcode;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]); 
            if (i < cost.length) {
                dp[i] += cost[i];
            }
        }

        return dp[dp.length - 1];
    }
}
