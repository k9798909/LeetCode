package leetcode;

import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * <p>
 * Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode.
 * <p>
 * Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }

            int asteroid = asteroids[i];
            while (asteroid != 0 && !stack.isEmpty()) {
                int leftAsteroid = stack.pop();
                if ((leftAsteroid < 0 && asteroid < 0)
                        || (leftAsteroid > 0 && asteroid > 0)
                        || (leftAsteroid < 0 && asteroid > 0)) {
                    stack.push(leftAsteroid);
                    stack.push(asteroid);
                    asteroid = 0;
                } else if (leftAsteroid + asteroid == 0) {
                    asteroid = 0;
                } else if (Math.abs(leftAsteroid) > Math.abs(asteroid)) {
                    stack.push(leftAsteroid);
                    asteroid = 0;
                }
            }

            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
