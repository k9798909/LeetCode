package leetcode;

import java.util.Arrays;

public class MinStack2 {

	private int[] intAry;

	public MinStack2() {
		this.intAry = new int[0];
//		this.intAry = new int[0];
//		intAry = new int[]{};
	}

	public void push(int val) {
//		int[] tempAry = this.intAry;
//		this.intAry = new int[this.intAry.length + 1];
//		for (int i = 0; i < tempAry.length; i++) {
//			this.intAry[i] = tempAry[i];
//		}
		this.intAry = Arrays.copyOf(intAry,this.intAry.length + 1);
		intAry[intAry.length - 1] = val;
	}

	public void pop() {
//		if (this.intAry.length != 0) {
//			int[] tempAry = this.intAry;
//			this.intAry = new int[this.intAry.length - 1];
//			for (int i = 0; i < this.intAry.length; i++) {
//				this.intAry[i] = tempAry[i];
//			}
//		}
		this.intAry = Arrays.copyOf(intAry,this.intAry.length - 1);
	}

	public Integer top() {
		if (this.intAry.length != 0) {
			return this.intAry[this.intAry.length - 1];
		} else {
			return null;
		}
	}

	public Integer getMin() {
		if (this.intAry.length != 0) {
			int min = this.intAry[0];
			for (int i = 1; i < this.intAry.length; i++) {
				if (min > this.intAry[i]) {
					min = this.intAry[i];
				}
			}
			return min;
		}
		return null;
	}
}
