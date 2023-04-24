package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
	Set<List<Integer>> ans = new HashSet<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		ans.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			subset(nums, i, new ArrayList<>());
		}
		return new ArrayList<>(ans);
	}

	public void subset(int[] nums, Integer i, List<Integer> list) {
		list.add(nums[i]);
		if (!ans.contains(list)) {
			ans.add(new ArrayList<>(list));
		}
		for (int j = i + 1; j < nums.length; j++) {
			subset(nums, j, new ArrayList<>(list));
		}
	}
}
