package leetcode;

public class ElementAppearingMoreThan25InSortedArray1287 {
	/**
	 * Given an integer array sorted in non-decreasing order, there is exactly one
	 * integer in the array that occurs more than 25% of the time, return that
	 * integer.
	 */
	public ElementAppearingMoreThan25InSortedArray1287() {

	}

	public int findSpecialInteger(int[] arr) {
		int moreThanNum = arr.length / 4;
		int currNum = arr[0];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (currNum != arr[i]) {
				count = 1;
				currNum = arr[i];
			} else {
				count++;
			}
			
			if (moreThanNum < count) {
				return arr[i];
			}
		}

		return currNum;
	}

}
