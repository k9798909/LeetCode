package leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		//cnt 依序遞增直到陣列做完，i會再回圈內一直加直到值不重複才停止
		int cnt = 0;
		int i = 0;
		while (nums.length > i) {
			nums[cnt] = nums[i];
			while (nums.length > i && nums[cnt] == nums[i]) {
				i++;
			}
			cnt++;
		}
		return cnt;
	}
}
