package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength1456 {
    /**
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     * <p>
     * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int[] isVowels = new int[123];
        isVowels['a'] = 1;
        isVowels['e'] = 1;
        isVowels['i'] = 1;
        isVowels['o'] = 1;
        isVowels['u'] = 1;

        char[] charArray = s.toCharArray();
        int maxCnt = 0;
        for (int i = 0; i < charArray.length && i < k; i++) {
            if (isVowels[charArray[i]] == 1) {
                ++maxCnt;
            }
        }

        int cnt = maxCnt;
        for (int i = k; i < charArray.length; i++) {
            if (isVowels[charArray[i - k]] == 1) {
                cnt--;
            }

            if (isVowels[charArray[i]] == 1) {
                cnt++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }

        return maxCnt;
    }
}
