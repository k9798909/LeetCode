package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
	List<List<Integer>> mainList = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		find(candidates, target, 0);
		return new ArrayList<>(mainList);
	}

	public void find(int[] candidates, int sum, int index) {

		if (sum == 0) {
			mainList.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			//不重複做
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}

			int tempSum = sum - candidates[i];
			if (tempSum < 0) {
				return;
			}

			list.add(candidates[i]);
			find(candidates, tempSum, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
