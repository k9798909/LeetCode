package leetcode;

import java.util.Iterator;

/**
 * You are given a 0-indexed m x n matrix grid consisting of positive integers.
 * 
 * You can start at any cell in the first column of the matrix, and traverse the
 * grid in the following way:
 * 
 * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1),
 * (row, col + 1) and (row + 1, col + 1) such that the value of the cell you
 * move to, should be strictly bigger than the value of the current cell. Return
 * the maximum number of moves that you can perform.
 */
public class MaximumNumberOfMovesInAGrid2684 {
	int[][] grid = null;
	boolean[][] dp = null;

	public int maxMoves(int[][] grid) {
		int maxCnt = 0;
		this.grid = grid;
		this.dp = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			maxCnt = Math.max(dfs(i, 0), maxCnt);
		}
		return maxCnt;
	}

	public int dfs(int row, int col) {
		if (dp[row][col]) {
			return 0;
		}
		
		int currNum = grid[row][col];
		int maxCnt = 0;

		if (col + 1 < grid[row].length) {
			if (row - 1 >= 0 && grid[row - 1][col + 1] > currNum) {
				maxCnt = Math.max(dfs(row - 1, col + 1) + 1, maxCnt);
			}

			if (grid[row][col + 1] > currNum) {
				maxCnt = Math.max(dfs(row, col + 1) + 1, maxCnt);
			}

			if (row + 1 < grid.length && grid[row + 1][col + 1] > currNum) {
				maxCnt = Math.max(dfs(row + 1, col + 1) + 1, maxCnt);
			}
		}
		
		dp[row][col] = true;

		return maxCnt;
	}
}
