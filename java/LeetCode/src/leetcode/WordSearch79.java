package leetcode;

public class WordSearch79 {
	char[][] board = null;
	boolean[][] visted = null;
	char[] wordChar = null;
	
	public  boolean exist(char[][] board, String word) {
		this.board = board;
		this.wordChar = word.toCharArray();
		this.visted = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (find(0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean find(int charIndex, int i, int j) {
		boolean done = false;
		this.visted[i][j] = true;
		if (wordChar[charIndex] == board[i][j]) {
			charIndex = charIndex + 1;
			if (charIndex >= wordChar.length) {
				return true;
			}
			
			if (i + 1 < board.length && !this.visted[i + 1][j]) {
				done = done || find(charIndex, i + 1, j);
			}
			
			if (i - 1 >= 0 && !this.visted[i - 1][j]) {
				done = done || find(charIndex, i - 1, j);
			}
			
			if (j + 1 < board[i].length && !this.visted[i][j + 1]) {
				done = done || find(charIndex, i, j + 1);
			}
			
			if (j - 1 >= 0 && !this.visted[i][j - 1]) {
				done = done || find(charIndex, i, j - 1);
			}
		}
		this.visted[i][j] = false;
		return done;
	}
	
	public static void main(String[] args) {
		System.out.println(new WordSearch79().exist(new char[][] {{'A','B'}}, "AB"));
	}
}
