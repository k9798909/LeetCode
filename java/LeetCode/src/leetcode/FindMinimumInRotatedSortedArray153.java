package leetcode;

public class FindMinimumInRotatedSortedArray153 {
	public int findMin(int[] nums) {
		quickSort(nums, 0, nums.length);
		return nums[0];
	}

	public static void quickSort(int[] nums, int left, int right) {
		int pivot = left;
		int i = left + 1;
		int j = right - 1;

		if (i > j) {
			return;
		}

		while (i < j) {
			while (i < j && nums[i] < nums[pivot]) {
				i++;
			}

			while (i < j && nums[j] > nums[pivot]) {
				j--;
			}
			swap(nums, i, j);
		}

		if (nums[j] < nums[pivot]) {
			swap(nums, pivot, j);
		}

		quickSort(nums, left, j);
		quickSort(nums, j, right);
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
