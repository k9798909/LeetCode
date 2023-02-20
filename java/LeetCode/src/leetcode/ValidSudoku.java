package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		Set<Character> set = new HashSet<>();
        	for (int j = 0; j < board[i].length; j++) {
        		if (board[i][j] == '.') {
        			continue;
        		}
        		
        		if (set.contains(board[i][j])) {
        			return false;
        		} else {
        			set.add(board[i][j]);
        		}
    		}
		}
    	
    	for (int i = 0; i < board.length; i++) {
    		Set<Character> set = new HashSet<>();
        	for (int j = 0; j < board[i].length; j++) {
        		if (board[j][i] == '.') {
        			continue;
        		}
        		
        		if (set.contains(board[j][i])) {
        			return false;
        		} else {
        			set.add(board[j][i]);
        		}
    		}
		}
    	
    	
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Set<Character> set = new HashSet<>();
				for (int k = 0; k < 3; k++) {
					for (int f = 0; f < 3; f++) {
						if (board[i + k][j + f] == '.') {
							continue;
						}

						if (set.contains(board[i + k][j + f])) {
							return false;
						} else {
							set.add(board[i + k][j + f]);
						}
					}
				}
			}
		}


        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(Character.valueOf('1').hashCode());
		System.out.println(Character.valueOf('2').hashCode());
	}
}
