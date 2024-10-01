package leetcode;

/**
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to
 * 2 * 109.
 */
public class UniquePaths62 {
	// 使用動態規劃法(dp) O(m*n) O(m*n)
	// 先將最上排及最左邊那排填上1，因為走到最右邊及最下面後都只會有一種選擇。
	// 以3*3的格子來說 [1,1] = [2,1](1) + [1,2](1)
	// ，因為[1,1]會有兩總路線左或右，而左或右又只有一種方式所以加上去會等於該格能走的路線量
	public int uniquePaths(int m, int n) {
		int[][] grip = new int[m][n];

		for (int i = 0; i < grip.length; i++) {
			grip[i][0] = 1;
		}

		for (int i = 0; i < grip[0].length; i++) {
			grip[0][i] = 1;
		}

		for (int i = 1; i < grip.length; i++) {
			for (int j = 1; j < grip[i].length; j++) {
				int left = j >= 0 ? grip[i][j - 1] : 0;
				int top = i >= 0 ? grip[i - 1][j] : 0;

				grip[i][j] = left + top;
			}
		}

		return grip[m - 1][n - 1];
	}

}
