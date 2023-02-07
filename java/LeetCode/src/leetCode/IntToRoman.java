package leetCode;

public class IntToRoman {

	enum Roma {
		M("M", 1000),
		CM("CM", 900),
		D("D", 500),
		CD("CD", 400),
		C("C", 100),
		CX("XC", 90),
		L("L", 50),
		LX("XL", 40),
		X("X", 10),
		IX("IX", 9),
		V("V", 5),
		IV("IV", 4),
		I("I", 1),;

		private String roma;
		private int num;

		private Roma(String roma, int num) {
			this.roma = roma;
			this.num = num;
		}

		public String getRoma() {
			return roma;
		}

		public int getNum() {
			return num;
		}

	}

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		Roma[] romaArray = Roma.values();
		for (int i = 0; i < romaArray.length; i++) {
			int count = num / romaArray[i].getNum();
			for (int j = 0; j < count; j++) {
				sb.append(romaArray[i].getRoma());
			}
			num = num % romaArray[i].getNum();
		}

		return sb.toString();
	}
}
