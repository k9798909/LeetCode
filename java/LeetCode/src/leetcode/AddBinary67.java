package leetcode;

public class AddBinary67 {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int plus = 0;

		while (i > -1 || j > -1) {
			int aNum = i > -1 ? a.charAt(i) : 48;
			int bNum = j > -1 ? b.charAt(j) : 48;
			if (aNum + bNum + plus == 99) {
				plus = 1;
				sb.append("1");
			} else if (aNum + bNum + plus == 98) {
				plus = 1;
				sb.append("0");
			} else if (aNum + bNum + plus == 96) {
				plus = 0;
				sb.append("0");
			} else if (aNum + bNum + plus == 97) {
				plus = 0;
				sb.append("1");
			}
			i--;
			j--;
		}
		
		if (plus == 1) {
			sb.append("1");
		}
		
		return sb.reverse().toString();
	}
}
