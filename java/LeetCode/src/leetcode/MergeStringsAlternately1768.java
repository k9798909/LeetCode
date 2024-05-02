package leetcode;

/**
 * MergeStringsAlternately1768
 */
public class MergeStringsAlternately1768 {

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < word1Array.length || j < word2Array.length) {
            if (i < word1Array.length) {
                sb.append(word1Array[i]);
            }

            if (j < word2Array.length) {
                sb.append(word2Array[j]);
            }

            i++;
            j++;
        }

        return sb.toString();
    }
}