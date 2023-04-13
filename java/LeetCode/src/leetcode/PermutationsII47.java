package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII47 {
	Set<List<Integer>> ans = new HashSet<>();
	LinkedList<Integer> list = new LinkedList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] visted = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i - 1 >= 0 && nums[i] == nums[i-1]) {
				continue;
			}
			visted[i] = true;
			list.add(nums[i]);
			permut(nums, visted);
			visted[i] = false;
			list.removeLast();
		}
		return new ArrayList<>(ans);
	}

	public void permut(int[] nums, boolean[] visted) {
		if (list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (!visted[i]) {
				visted[i] = true;
				list.add(nums[i]);
				permut(nums, visted);
				list.removeLast();
				visted[i] = false;
			}
		}
		
	}

	
}
