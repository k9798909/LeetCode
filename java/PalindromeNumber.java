package leetCode;

public class PalindromeNumber {
	
    public static boolean isPalindrome(int x) {
    	String intStr = String.valueOf(x);
    	int mid = intStr.length() / 2;
    	int start = mid - 1;
    	int end = mid + intStr.length() % 2;
    	
		while (end < intStr.length()) {
			if (intStr.charAt(start--) != intStr.charAt(end++)) {
				return false;
			}
		}
		
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
	}
}
