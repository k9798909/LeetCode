package leetcode;

public class MultiplyStrings43 {
	public String multiply(String num1, String num2) {
		if ("0".equals(num2) || "0".equals(num1)) {
			return "0";
		}

		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();
		String sum = "0";
		String zero = "";
		for (int i = num2Arr.length - 1; 0 <= i; i--) {
			sum = add(sum, mul(num1Arr, num2Arr[i]) + zero);
			zero += "0";
		}
		
		return sum;
	}

	String add(String s1, String s2) {
		char[] num1Arr = s1.toCharArray();
		char[] num2Arr = s2.toCharArray();
		int plus = 0;
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (0 <= i || 0 <= j) {
			int num = (0 > i ? 48 : num1Arr[i]) + (0 > j ? 48 : num2Arr[j]) - 96 + plus;
			plus = num / 10;
			sb.append(num % 10);
			i--;
			j--;
		}
		
		if (plus == 1) {
			sb.append(plus);
		}
		
		return sb.reverse().toString();
	}
	
	String mul(char[] cArr, char c2) {
		StringBuilder sb = new StringBuilder();
		int plus = 0;
		for (int i = cArr.length - 1; 0 <= i; i--) {
			int num = (cArr[i] - 48) * (c2 - 48) + plus;
			plus = num / 10;
			sb.append(num % 10);
		}
		
		if (plus != 0) {
			sb.append(plus);
		}
		
		return sb.reverse().toString();
	}
}
