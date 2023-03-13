package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		int i = aArray.length - 1;
		int j = bArray.length - 1;
		int plus = 0;

		while (i > -1 || j > -1) {
			int aNum = i > -1 ? aArray[i] : 48;
			int bNum = j > -1 ? bArray[j] : 48;
			if (aNum + bNum + plus == 99) {
				plus = 1;
				sb.insert(0,"1");
			} else if (aNum + bNum + plus == 98) {
				plus = 1;
				sb.insert(0,"0");
			} else if (aNum + bNum + plus == 96) {
				plus = 0;
				sb.insert(0,"0");
			} else if (aNum + bNum + plus == 97) {
				plus = 0;
				sb.insert(0,"1");
			}
			i--;
			j--;
		}
		
		if (plus == 1) {
			sb.insert(0,"1");
		}
		
		return sb.toString();
	}
}
