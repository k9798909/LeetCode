package leetcode;

public class LengthOfLastWord58 {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		for (int i = s.length() - 1; 0 <= i; i--) {
			if (' ' == s.charAt(i)) {
				return s.length() - 1 - i;
			}
		}

		return s.length();
	}
}
