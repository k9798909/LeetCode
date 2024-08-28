package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented
 * as '.') and walls (represented as '+'). You are also given the entrance of
 * the maze, where entrance = [entrancerow, entrancecol] denotes the row and
 * column of the cell you are initially standing at.
 * 
 * In one step, you can move one cell up, down, left, or right. You cannot step
 * into a cell with a wall, and you cannot step outside the maze. Your goal is
 * to find the nearest exit from the entrance. An exit is defined as an empty
 * cell that is at the border of the maze. The entrance does not count as an
 * exit.
 * 
 * Return the number of steps in the shortest path from the entrance to the
 * nearest exit, or -1 if no such path exists.
 */
public class NearestExitFromEntranceInMaze1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean isEntrance = true;
        boolean isPathExists = false;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);

        maze[entrance[0]][entrance[1]] = 'X';

        int cnt = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int[] standing = queue.poll();
                int down = standing[0] + 1;
                int right = standing[1] + 1;
                int up = standing[0] - 1;
                int left = standing[1] - 1;

                if (!isEntrance && (down >= maze.length
                        || up < 0
                        || right >= maze[standing[0]].length
                        || left < 0)) {
                    queue.clear();
                    isPathExists = true;
                    break;
                }

                if (down < maze.length && maze[down][standing[1]] == '.') {
                    queue.add(new int[] { down, standing[1] });
                    maze[down][standing[1]] = 'X';
                }

                if (up >= 0 && maze[up][standing[1]] == '.') {
                    queue.add(new int[] { up, standing[1] });
                    maze[up][standing[1]] = 'X';
                }

                if (right < maze[standing[0]].length && maze[standing[0]][right] == '.') {
                    queue.add(new int[] { standing[0], right });
                    maze[standing[0]][right] = 'X';
                }

                if (left >= 0 && maze[standing[0]][left] == '.') {
                    queue.add(new int[] { standing[0], left });
                    maze[standing[0]][left] = 'X';
                }

            }

            if (!isEntrance) {
                cnt++;
            } else {
                isEntrance = false;
            }

        }

        return isPathExists ? cnt : -1;
    }
}
