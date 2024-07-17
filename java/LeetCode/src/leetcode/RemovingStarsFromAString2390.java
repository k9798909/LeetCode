package leetcode;

import java.util.Stack;

public class RemovingStarsFromAString2390 {
    /**
     * You are given a string s, which contains stars *.
     *
     * In one operation, you can:
     *
     * Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star itself.
     * Return the string after all stars have been removed.
     *
     * Note:
     *
     * The input will be generated such that the operation is always possible.
     * It can be shown that the resulting string will always be unique.
     * @param s
     * @return
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
