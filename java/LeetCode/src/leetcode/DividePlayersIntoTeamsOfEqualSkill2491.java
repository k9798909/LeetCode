package leetcode;

import java.util.Arrays;

/**
 * You are given a positive integer array skill of even length n where skill[i]
 * denotes the skill of the ith player. Divide the players into n / 2 teams of
 * size 2 such that the total skill of each team is equal.
 * 
 * The chemistry of a team is equal to the product of the skills of the players
 * on that team.
 * 
 * Return the sum of the chemistry of all the teams, or return -1 if there is no
 * way to divide the players into teams such that the total skill of each team
 * is equal.
 */
public class DividePlayersIntoTeamsOfEqualSkill2491 {
	public long dividePlayers(int[] skill) {
		Arrays.sort(skill);

		int left = 0, right = skill.length - 1;
		int tempSum = skill[left] + skill[right];
		long result = skill[left] * skill[right];
		left++;
		right--;

		while (left < right) {
			if (tempSum != skill[left] + skill[right]) {
				return -1;
			}

			result += skill[left] * skill[right];
			left++;
			right--;
		}

		return result;
	}
}
