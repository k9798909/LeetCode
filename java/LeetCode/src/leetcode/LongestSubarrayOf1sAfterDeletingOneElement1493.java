package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
    public int longestSubarray(int[] nums) {
        int maxCnt = 0;
        int i = 0;
        while (i < nums.length) {
            maxCnt++;
            if (nums[i] == 0) {
                nums[i] = -1;
                i++;
                break;
            }

            i++;
        }

        int cnt = maxCnt;
        int j = 0;
        while (i < nums.length) {
            cnt++;

            if (nums[i] == 0) {
                nums[i] = -1;
                while (nums[j] == 1) {
                    cnt--;
                    j++;
                }
                cnt--;
                j++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }

            i++;
        }
        return maxCnt - 1;
    }
}
