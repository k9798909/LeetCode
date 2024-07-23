package leetcode;

/**
 * Given an array of characters chars, compress it using the following
 * algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately,
 * but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple
 * characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the
 * array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * Example 1:
 * <p>
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
 * "a2b2c3".
 * Example 2:
 * <p>
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a
 * single character.
 * Example 3:
 * <p>
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be:
 * ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to
 * "ab12".
 *
 */
public class StringCompression443 {

    public int compress(char[] chars) {
        int idx = 0;
        int resultIdx = 0;

        while (idx < chars.length) {
            char grpChar = chars[idx];
            int grpCnt = 0;
            while (idx < chars.length && chars[idx] == grpChar) {
                grpCnt++;
                idx++;
            }

            chars[resultIdx++] = grpChar;
            if (grpCnt > 1) {
                char[] cntChars = String.valueOf(grpCnt).toCharArray();
                for (int j = 0; j < cntChars.length; j++) {
                    chars[resultIdx++] = cntChars[j];
                }
            }
        }

        return resultIdx;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression443()
                .compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
    }
}
