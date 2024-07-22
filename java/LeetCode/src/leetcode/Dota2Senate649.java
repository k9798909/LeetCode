package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {
    /**
     * In the world of Dota2, there are two parties: the Radiant and the Dire.
     * <p>
     * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game.
     * <p>
     * The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
     * <p>
     * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
     * <p>
     * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party,
     * <p>
     * he can announce the victory and decide on the change in the game.
     * <p>
     * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators,
     * <p>
     * the size of the given string will be n.
     * <p>
     * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting.
     * <p>
     * All the senators who have lost their rights will be skipped during the procedure.
     * <p>
     * Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game.
     * <p>
     * The output should be "Radiant" or "Dire".
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> queueD = new LinkedList<>();
        Queue<Integer> queueR = new LinkedList<>();
        char[] chars = senate.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (chars[i] == 'D') {
                queueD.add(i);
            } else {
                queueR.add(i);
            }
        }


        while (!queueD.isEmpty() && !queueR.isEmpty()) {
            if (queueD.peek() < queueR.peek()) {
                queueR.poll();
                queueD.add(queueD.poll() + chars.length);
            } else {
                queueD.poll();
                queueR.add(queueR.poll() + chars.length);
            }
        }

        return queueR.isEmpty() ? "Dire" : "Radiant";
    }
}
