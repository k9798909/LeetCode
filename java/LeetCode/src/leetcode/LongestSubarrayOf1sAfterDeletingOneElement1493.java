package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayOf1sAfterDeletingOneElement1493 {
	public int longestSubarray(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				list.add(i);
			}
		}

		
		if (list.size() == 0) {
			return nums.length - 1;
		} else if (list.size() == 1) {
			return nums.length - 1;
		} else {
			List<Integer> cutList = new ArrayList<>();
			cutList.add(list.get(0) - 0);
			for (int i = 1; i < list.size(); i++) {
				cutList.add(list.get(i) - list.get(i - 1) - 1);
			}
			cutList.add(nums.length - 1 - list.get(list.size() - 1));

			int max = 0;
			for (int i = 1; i < cutList.size(); i++) {
				max = Math.max(max, cutList.get(i) + cutList.get(i - 1));
			}
			return max;
		}

	}
}
