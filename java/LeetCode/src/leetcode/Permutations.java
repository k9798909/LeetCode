package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	List<List<Integer>> list = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> subList = new ArrayList<>();
		boolean[] isDone = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			isDone[i] = true;
			subList.add(nums[i]);
			permute(isDone, nums, subList);
			subList.remove(subList.size() - 1);
			isDone[i] = false;
		}
		return list;
	}

	public void permute(boolean[] isDone, int[] nums, List<Integer> subList) {
		if (subList.size() == nums.length) {
			list.add(new ArrayList<>(subList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (isDone[i]) {
				continue;
			}

			subList.add(nums[i]);
			isDone[i] = true;
			permute(isDone, nums, subList);
			subList.remove(subList.size() - 1);
			isDone[i] = false;
		}
	}

}
