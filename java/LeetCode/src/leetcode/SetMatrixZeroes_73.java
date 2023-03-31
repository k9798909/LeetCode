package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes_73 {
	public void setZeroes(int[][] matrix) {
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					xSet.add(j);
					ySet.add(i);
				}
			}
		}
		
		for (int x : xSet) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][x] = 0;
			}
		}
		
		for (int y : ySet) {
			for (int i = 0; i < matrix[y].length; i++) {
				matrix[y][i] = 0;
			}
		}
		
	}
	
	
}
