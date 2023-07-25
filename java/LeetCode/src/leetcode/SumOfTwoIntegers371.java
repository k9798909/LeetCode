package leetcode;

public class SumOfTwoIntegers371 {
	public int getSum(int a, int b) {
		//代表進位完了
		if (b == 0) {
			return a;
		} 
	    int sum = a ^ b;//相同位不同=1，相同位相同=0
	    int carry = (a & b) << 1;//相同位是1，= 1，相同位是0， = 0。之後往左移1位
	    return getSum(sum, carry);
	}
}
