package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static String longestPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return s;
		}
		
		String rtnStr = "";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length(); j != i; j--) {
				String tempStr = s.substring(i,j);
				
				if(tempStr.length() <= rtnStr.length()) {
					break;
				}
				
				int middle = tempStr.length() / 2;
				StringBuilder sb = new StringBuilder();
				if(tempStr.length() % 2 != 0) {
					sb.append(tempStr.charAt(middle));
					for (int k = 1 ; k <= middle; k++) {
						if (tempStr.charAt(middle - k) == tempStr.charAt(middle + k)) {
							sb.insert(0,tempStr.charAt(middle - k));
							sb.append(tempStr.charAt(middle + k));
						} else {
							break;
						}
					}
				} else {
					for (int k = 0 ; k < middle; k++) {
						if (tempStr.charAt(middle - k - 1) == tempStr.charAt(middle + k)) {
							sb.insert(0,tempStr.charAt(middle - k - 1));
							sb.append(tempStr.charAt(middle + k));
						} else {
							break;
						}
					}
				}

				
				if(rtnStr.length() < sb.toString().length()) {
					rtnStr = sb.toString();
				}
				
			}
		}
		return rtnStr;
	}
	
	
	public static String longestPalindrome2(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return s;
		}
		
		String rtnStr = "";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length(); j != i; j--) {
				String tempStr = s.substring(i,j);
				
				if(tempStr.length() <= rtnStr.length()) {
					break;
				}
				
				boolean isSame = true;
				
				int middle = tempStr.length() / 2;
				for (int k = 0; k < middle; k++) {
					if (!(tempStr.charAt(k) == tempStr.charAt(tempStr.length() - 1 - k))) {
						isSame = false;
						break;
					}
				}
				
				if(isSame && rtnStr.length() < tempStr.length()) {
					rtnStr = tempStr;
				}
				
			}
			
		}
		return rtnStr;
	}
	
	
	public static String longestPalindrome3(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}

		String rtnStr = "";

		for (int i = 0; i < s.length(); i++) {
			String oddStr = findStr(s,i-1,i+1);
			String evenStr = findStr(s,i,i+1);
			String tempStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;

			if (rtnStr.length() < tempStr.length()) {
				rtnStr = tempStr;
			}
		}
		return rtnStr;
	}
	
	public static String findStr(String s,int start,int end) {
		if (start < 0 || end >= s.length()) {
			return "";
		}
		int r = 0;
		int l = 0;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			l = start--;
			r = end++;
		}
		return s.substring(l,r + 1);
	}
	


	public static void main(String[] args) {
		System.out.println(longestPalindrome3("aaaa"));
	}
}
