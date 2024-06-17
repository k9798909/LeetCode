package leetcode;

public class GreatestCommonDivisorOfStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals((str2 + str1))) {
            return "";
        }
        String s1 = str1.length() >= str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str1 : str2;
        return divisor(s1, s2);
    }

    /**
     * 用大的去除以小的直到除的進為止
     * 
     * @param s1 大的
     * @param s2 小的
     * @return
     */
    public String divisor(String s1, String s2) {
        int remainder = s1.length() % s2.length();
        if (remainder != 0) {
            return divisor(s2, s1.substring(0, remainder));
        }
        return s2;
    }

}
