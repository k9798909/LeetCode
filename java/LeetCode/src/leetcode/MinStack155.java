package leetcode;

public class MinStack155 {

	private int[] intAry;

	public MinStack155() {
		this.intAry = new int[0];
	}

	public void push(int val) {
		int[] tempAry = this.intAry;
		this.intAry = new int[this.intAry.length + 1];
		for (int i = 0; i < tempAry.length; i++) {
			this.intAry[i] = tempAry[i];
		}
		intAry[intAry.length - 1] = val;
	}

	public void pop() {
		if (this.intAry.length != 0) {
			int[] tempAry = this.intAry;
			this.intAry = new int[this.intAry.length - 1];
			for (int i = 0; i < this.intAry.length; i++) {
				this.intAry[i] = tempAry[i];
			}
		}
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
