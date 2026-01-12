package leetcode;

/**
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
 * Return the minimum time in seconds to visit all the points in the order given by points.
 * <p>
 * You can move according to these rules:
 * <p>
 * In 1 second, you can either:
 * move vertically by one unit,
 * move horizontally by one unit, or
 * move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
 * You have to visit the points in the same order as they appear in the array.
 * You are allowed to pass through points that appear later in the order, but these do not count as visits.
 */
public class MinimumTimeVisitingAllPoints1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int cnt = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int width = points[i][0] - points[i + 1][0];
            int height = points[i][1] - points[i + 1][1];
            cnt += Math.max(Math.abs(width), Math.abs(height));
        }
        return cnt;
    }

}
