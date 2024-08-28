package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 */
public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                
                if (pos[0] + 1 < grid.length) {
                    int newPosNum = pos[0] + 1;
                    if (grid[newPosNum][pos[1]] == 1) {
                        grid[newPosNum][pos[1]] = 2;
                        queue.add(new int[] { newPosNum, pos[1] });
                    }
                }

                if (pos[0] - 1 >= 0) {
                    int newPosNum = pos[0] - 1;
                    if (grid[newPosNum][pos[1]] == 1) {
                        grid[newPosNum][pos[1]] = 2;
                        queue.add(new int[] { newPosNum, pos[1] });
                    }
                }

                if (pos[1] + 1 < grid[pos[0]].length) {
                    int newPosNum = pos[1] + 1;
                    if (grid[pos[0]][newPosNum] == 1) {
                        grid[pos[0]][newPosNum] = 2;
                        queue.add(new int[] { pos[0], newPosNum });
                    }
                }

                if (pos[1] - 1 >= 0) {
                    int newPosNum = pos[1] - 1;
                    if (grid[pos[0]][newPosNum] == 1) {
                        grid[pos[0]][newPosNum] = 2;
                        queue.add(new int[] { pos[0], newPosNum });
                    }
                }
            }

            cnt++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return cnt == 0 ? 0 : cnt - 1;
    }
}
