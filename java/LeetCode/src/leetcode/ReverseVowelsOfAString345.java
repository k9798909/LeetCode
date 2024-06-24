package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString345 {

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     *
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if (vowels.contains(chars[i]) && vowels.contains(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
                continue;
            }

            if (!vowels.contains(chars[j])) {
                j--;
            }

            if (!vowels.contains(chars[i])) {
                i++;
            }

        }

        return new String(chars);
    }
}
