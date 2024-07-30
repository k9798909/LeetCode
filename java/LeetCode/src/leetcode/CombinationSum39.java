package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		combination(new ArrayList<>(), candidates, 0, target);
		return list;
	}
	
	//每一次處理都會將target去除num，取得最大的次數，如果最大的次數乘數字=target加進list，如果沒有但小於target 則target - sum以及idx + 1再丟進去處理一層一層解出來依序找到加進list。
	public void combination(List<Integer> subList, int[] candidates, int idx, int target) {
		int num = candidates[idx];
		int cnt = target / num;
		//先將最大次數add進去，下列回圈每做一次remove一次
		for (int j = 0; j < cnt; j++) {
			subList.add(num);
		}
		for (int i = cnt; 0 <= i; i--) {
			int sum = num * i;
			if (target == sum) {
				list.add(new ArrayList<>(subList));
			} else if (sum < target && idx + 1 < candidates.length) {
				combination(new ArrayList<>(subList), candidates, idx + 1, target - sum);
			}
			if (!subList.isEmpty()) {
				subList.remove(subList.size() - 1);
			}
		}
	}

}
