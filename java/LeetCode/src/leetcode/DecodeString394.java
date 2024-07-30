package leetcode;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string],
 * <p>
 * where the encoded_string inside the square brackets is being repeated exactly
 * k times.
 * <p>
 * Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k.
 * <p>
 * For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never
 * exceed 105.
 *
 */
public class DecodeString394 {

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                n = n * 10 + chars[i] - '0';
            } else if (chars[i] == '[') {
                strStack.push(sb);
                intStack.push(n);
                sb = new StringBuilder();
                n = 0;
            } else if (chars[i] == ']') {
                StringBuilder temp = strStack.pop();
                int cnt = intStack.pop();
                for (int j = 0; j < cnt; j++) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

}
