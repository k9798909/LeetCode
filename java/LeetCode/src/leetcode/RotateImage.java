package leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		//一個一個換
		int length = matrix.length;
		for (int i = 0; i < length - 1; i++) {
			//要換的長度 長度 4 要換 3 個 長度 5 要換 4 個，每換完一個長度都會遞減 遞減數 = i
			for (int j = i; j < length - i - 1; j++) {
				int lt = matrix[i][j];
				int rt = matrix[j][length - 1 - i];
				int rd = matrix[length - 1 - i ][length - 1 - j];
				int ld = matrix[length - 1 - j][i];
				matrix[i][j] = ld;
				matrix[j][length - 1 - i] = lt;
				matrix[length - 1 - i][length - 1 - j] = rt;
				matrix[length - 1 - j][i] = rd;
			}
		}
		
	}

	public static void main(String[] args) {
		new RotateImage().rotate(new int[][] { { 5, 1, 9, 11 }, 
			                                   { 2, 4, 8, 10 }, 
			                                   { 13, 3, 6, 7 }, 
			                                   { 15, 14, 12, 16 }
			                                 });
	}
}
