package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string allowed consisting of distinct characters and an array
 * of strings words. A string is consistent if all characters in the string
 * appear in the string allowed.
 * 
 * Return the number of consistent strings in the array words.
 */
public class CountTheNumberOfConsistentStrings1684 {
	public int countConsistentStrings(String allowed, String[] words) {
		Set<Character> allowedSet = new HashSet<>();
		for (char c : allowed.toCharArray()) {
			allowedSet.add(c);
		}

		int cnt = 0;
		for (String word : words) {
			boolean hasNotAllow = false;
			for (char c : word.toCharArray()) {
				if (!allowedSet.contains(c)) {
					hasNotAllow = true;
					break;
				}
			}
			
			if (!hasNotAllow) {
				cnt++;
			}
		}
		return cnt;
	}
}
