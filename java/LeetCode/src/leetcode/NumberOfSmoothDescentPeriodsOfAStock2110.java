package leetcode;

public class NumberOfSmoothDescentPeriodsOfAStock2110 {
    public long getDescentPeriods(int[] prices) {
        int dp = 1;
        long sum = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                dp++;
            } else {
                dp = 1;
            }
            sum += dp;
        }
        return sum;
    }
}
