package leetcode;

/**
 * <p>
 * You are given a 0-indexed m x n binary matrix grid.
 * </p>
 * <p>
 * A 0-indexed m x n difference matrix diff is created with the following
 * </p>
 * <p>
 * procedure:
 * </p>
 * <p>
 * Let the number of ones in the ith row be onesRowi.
 * </p>
 * <p>
 * Let the number of ones in the jth column be onesColj.
 * </p>
 * <p>
 * Let the number of zeros in the ith row be zerosRowi.
 * </p>
 * <p>
 * Let the number of zeros in the jth column be zerosColj.
 * </p>
 * <p>
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj Return the
 * difference matrix diff.
 * </p>
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn2482 {
	public int[][] onesMinusZeros(int[][] grid) {
		int[] rowSum = new int[grid.length];
		int[] colSum = new int[grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					rowSum[i]++;
					colSum[j]++;
				} else if (grid[i][j] == 0) {
					rowSum[i]--;
					colSum[j]--;
				}
			}
		}
		int[][] result = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				result[i][j] = rowSum[i] + colSum[j];
			}
		}

		return result;
	}
}
