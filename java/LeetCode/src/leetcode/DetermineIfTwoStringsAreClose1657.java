package leetcode;

import java.util.*;

/**
 * Two strings are considered close if you can attain one from the other using
 * the following operations:
 * <p>
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into
 * another existing character,
 * and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into
 * a's)
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close,
 * and false otherwise.
 *
 */
public class DetermineIfTwoStringsAreClose1657 {

    public boolean closeStrings(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        if (charArray1.length != charArray2.length) {
            return false;
        }

        int[] wordCharsCnt1 = new int[26];
        int[] wordCharsCnt2 = new int[26];

        for (int i = 0; i < charArray2.length; i++) {
            wordCharsCnt2[charArray2[i] - 'a']++;
        }

        for (int i = 0; i < charArray1.length; i++) {
            if (wordCharsCnt2[charArray1[i] - 'a'] == 0) {
                return false;
            }
            wordCharsCnt1[charArray1[i] - 'a']++;
        }

        Arrays.sort(wordCharsCnt1);
        Arrays.sort(wordCharsCnt2);
        return Arrays.equals(wordCharsCnt1, wordCharsCnt2);
    }
}
