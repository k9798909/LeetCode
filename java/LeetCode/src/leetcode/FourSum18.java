package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		long targetL = (long) target;
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
					if (sum > targetL) {
						r--;
					} else if (sum < targetL) {
						l++;
					} else if (sum == targetL) {
						list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while(l < r && nums[r--] == nums[r]);
						while(l < r && nums[l++] == nums[l]);
					}
				}
			}
		}
		return list;
	}

}
