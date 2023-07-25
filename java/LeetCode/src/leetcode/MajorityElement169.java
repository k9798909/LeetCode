package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int majorityCnt = nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			int cnt = 0;
			if (map.containsKey(nums[i])) {
				cnt = map.get(nums[i]) + 1;
			} else {
				cnt = 1;
			}
			map.put(nums[i], cnt);
			if (cnt > majorityCnt) {
				return nums[i];
			}
		}

		return 0;
	}
}
