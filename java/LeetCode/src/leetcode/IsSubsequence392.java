package leetcode;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int j = 0;
        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] == sChars[j]) {
                j++;
            }

            if (j >= sChars.length) {
                return true;
            }
        }

        return false;
    }
}
