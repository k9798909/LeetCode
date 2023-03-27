package leetcode;

public class MinimumPathSum {
	// DP（動態規劃，Dynamic Programming）動態規劃演算法的核心思想是記錄中間結果，以避免重複計算
	public int minPathSum(int[][] grid) {
		int xLen = grid[0].length;
		int yLen = grid.length;

		// 紀錄最左邊那一排到達的距離
		for (int i = 1; i < yLen; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}

		// 紀錄最上方那一列到達的距離
		for (int i = 1; i < xLen; i++) {
			grid[0][i] = grid[0][i - 1] + grid[0][i];
		}

		// 開始記錄每一格到達的最小距離，用上面那格和左邊那格取小的加起來。
		for (int i = 1; i < yLen; i++) {
			for (int j = 1; j < xLen; j++) {
				grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
			}
		}

		return grid[yLen - 1][xLen - 1];
	}
}
