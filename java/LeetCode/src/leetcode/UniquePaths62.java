package leetcode;

public class UniquePaths62 {
	//使用動態規劃法(dp)  O(m*n) O(m*n) 
	//先將最下排及最右邊那排填上1，因為走到最右邊及最下面後都只會有一種選擇。
	//以3*3的格子來說 [1,1] = [2,1](1) + [1,2](1) ，因為[1,1]會有兩總路線左或右，而左或右又只有一種方式所以加上去會等於該格能走的路線量
	public int uniquePaths(int m, int n) {
		int[][] grip = new int[m][n];
		
		for (int i = 0; i < grip[grip.length - 1].length; i++) {
			grip[grip.length - 1][i] = 1;
		}
		
		for (int i = 0; i < grip.length; i++) {
			grip[i][grip[i].length - 1] = 1;
		}
		
		for (int i = grip.length - 2; i >= 0; i--) {
			for (int j = grip[i].length - 2; j >= 0 ; j--) {
				grip[i][j] = grip[i + 1][j] + grip[i][j + 1];
			}
		}
		
		
		return grip[0][0];
	}

}
