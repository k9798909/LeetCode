package leetCode;

import java.util.Iterator;

public class ZigzagConversion {

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		char[] charStr = s.toCharArray();
		char[][] convertArray = new char[numRows][s.length()];
		int convertY = 0, convertX = 0, calY = 1;
		boolean isZigzag = false;
		for (int i = 0; i < charStr.length; i++) {
			convertArray[convertY][convertX] = charStr[i];

			if (isZigzag) {
				convertX++;
			}

			convertY += calY;
			if (convertY == 0 || convertY == numRows - 1) {
				isZigzag = !isZigzag;
				calY = calY == 1 ? -1 : 1;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < convertArray.length; i++) {
			for (int j = 0; j < convertArray[i].length; j++) {
				if (convertArray[i][j] != '\0') {
					sb.append(convertArray[i][j]);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("abc ", 7));
	}

}
