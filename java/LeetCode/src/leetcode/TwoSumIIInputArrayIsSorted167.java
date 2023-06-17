package leetcode;

public class TwoSumIIInputArrayIsSorted167 {
	public int[] twoSum(int[] numbers, int target) {
		for (int i = 0, j = numbers.length - 1; i < j;) {
			while (i < j && numbers[i] + numbers[j] < target) {
				i++;
			}

			while (numbers[i] + numbers[j] > target) {
				j--;
			}
			
			if (numbers[i] + numbers[j] == target) {
				return new int[] { i + 1, j + 1 };
			}
		}
		return null;
	}
}
