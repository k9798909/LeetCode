package leetcode;

/**
 * Given an m x n binary matrix mat, return the number of special positions in
 * mat. A position (i, j) is called special if mat[i][j] == 1 and all other
 * elements in row i and column j are 0 (rows and columns are 0-indexed).
 */
public class SpecialPositionsBinaryMatrix1582 {
	public int numSpecial(int[][] mat) {
		// 將橫的加起來、將縱的加起來
		int[] rowSum = new int[mat.length];
		int[] columnSum = new int[mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				rowSum[i] += mat[i][j];
				columnSum[j] += mat[i][j];
			}
		}
		
		// 縱的橫的都是1而且當前欄位是1，代表沒有交錯
		int result = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (rowSum[i] == 1 && columnSum[j] == 1) {
					if (mat[i][j] == 1) {
						result++;
					}
				}
			}
		}
		return result;
	}
}
