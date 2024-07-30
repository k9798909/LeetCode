package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 */
public class KeysAndRooms841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);

        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (visited[key]) {
                continue;
            }
            keys.addAll(rooms.get(key));
            visited[key] = true;
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }

        return true;
    }
}