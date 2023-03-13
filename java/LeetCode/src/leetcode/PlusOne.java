package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int plus = 1;
		int i = digits.length - 1;
		while (plus == 1) {
			if (i < 0) {
				int[] newArray = new int[digits.length + 1];
				newArray[0] = 1;
				digits = newArray;
				break;
			}
			
			digits[i] += 1;
			if (digits[i] < 10) {
				plus = 0;
			} else {
				digits[i] = 0;
			}
			i--;
		}

		return digits;
	}
}
