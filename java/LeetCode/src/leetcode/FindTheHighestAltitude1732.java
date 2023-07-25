package leetcode;

public class FindTheHighestAltitude1732 {
	public int largestAltitude(int[] gain) {
		int height = 0;
		int highest = 0;
		for (int i = 0; i < gain.length; i++) {
			height += gain[i];
			
			if (height > highest) {
				highest = height;
			}
		}
		return highest;
	}
}
