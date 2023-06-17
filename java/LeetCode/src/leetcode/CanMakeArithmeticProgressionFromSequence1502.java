package leetcode;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence1502 {
	public boolean canMakeArithmeticProgression(int[] arr) {
		if (arr == null || arr.length == 1) {
			return false;
		} else if (arr.length == 2) {
			return true;
		} else {
			Arrays.sort(arr);
			int def = arr[0] - arr[1];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1] - arr[i] != def) {
					return false;
				}
			}
		}
		return true;
	}
}
