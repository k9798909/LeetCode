package leetcode;

public class ReverseInteger7 {
	
    public static int reverse(int x) {
    	boolean isNegative = 0 > x;
    	char[] intAry = isNegative ? String.valueOf(x).substring(1).toCharArray() : String.valueOf(x).toCharArray();
    	
    	if(intAry.length > 10) {
    		return 0;
    	}
    	
    	int mid = intAry.length / 2;
    	int start = mid - 1;
    	int end = intAry.length % 2 == 0 ? mid : mid + 1;
		StringBuilder sb = intAry.length % 2 == 0 ? new StringBuilder() : new StringBuilder().append(intAry[mid]);
		for (; end < intAry.length; start--, end++) {
			sb.insert(0,intAry[end]);
			sb.append(intAry[start]);
		}
    	
    	if(Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
    		return 0;
    	}
    	
		return isNegative ? Integer.valueOf(sb.toString()) * -1 : Integer.valueOf(sb.toString());
    	
    }
    
    public static int reverse2(int x) {
    	boolean isNegative = 0 > x;
    	char[] intAry = isNegative ? String.valueOf(x).substring(1).toCharArray() : String.valueOf(x).toCharArray();
    	
    	if(intAry.length > 10) {
    		return 0;
    	}
    	
		for (int start = 0,end = intAry.length - 1; start < end; start++, end--) {
			char tempChar = intAry[end];
			intAry[end] = intAry[start];
			intAry[start] = tempChar;
		}
		
		String str = new String(intAry);
    	
    	if(Double.valueOf(str.toString()) > Integer.MAX_VALUE) {
    		return 0;
    	}
    	
		return isNegative ? Integer.valueOf(str.toString()) * -1 : Integer.valueOf(str.toString());
    	
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}

}
