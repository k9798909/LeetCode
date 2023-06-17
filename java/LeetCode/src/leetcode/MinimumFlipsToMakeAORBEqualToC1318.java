package leetcode;

public class MinimumFlipsToMakeAORBEqualToC1318 {
	public int minFlips(int a, int b, int c) {
		int cnt = 0;
		String aStr = Integer.toBinaryString(a);
		String bStr = Integer.toBinaryString(b);
		String cStr = Integer.toBinaryString(c);
		int aIdx = aStr.length() - 1, bIdx = bStr.length() - 1, cIdx = cStr.length() - 1;
		while (aIdx >= 0 || bIdx >= 0 || cIdx >= 0) {
			int aNum = aIdx < 0 ? 0 : aStr.charAt(aIdx) - '0';
			int bNum = bIdx < 0 ? 0 : bStr.charAt(bIdx) - '0';
			int cNum = cIdx < 0 ? 0 : cStr.charAt(cIdx) - '0';
			if (cNum == 1) {
				if (aNum + bNum == 0) {
					cnt += 1;
				}
			} else if (cNum == 0) {
				if (aNum + bNum == 2) {
					cnt += 2;
				} else if (aNum + bNum == 1) {
					cnt += 1;
				}
			}
			
			aIdx--;
			bIdx--;
			cIdx--;
		}

		return cnt;
	}

}
