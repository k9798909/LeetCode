package leetcode;

public class MaxConsecutiveOnesIII1004 {

    /**
     * Given a binary array nums and an integer k,
     * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        // [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
        int maxCnt = 0;
        int consecutiveCnt = 0;
        int flipCnt = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            consecutiveCnt++;

            if (nums[i] == 0 && flipCnt == k) {
                while (nums[j] == 1) {
                    j++;
                    consecutiveCnt--;
                }

                nums[i] = -1;
                j++;
                consecutiveCnt--;
            }

            if (nums[i] == 0) {
                nums[i] = -1;
                flipCnt++;
            }

            if (maxCnt < consecutiveCnt) {
                maxCnt = consecutiveCnt;
            }
        }
        return maxCnt;
    }
}
