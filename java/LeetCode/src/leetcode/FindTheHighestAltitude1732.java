package leetcode;

public class FindTheHighestAltitude1732 {

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
     * <p>
     * The biker starts his trip on point 0 with altitude equal 0.
     * <p>
     * You are given an integer array gain of length n
     * <p>
     * where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n).
     * <p>
     * Return the highest altitude of a point.
     *
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int height = 0;
        int highest = 0;
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];

            if (height > highest) {
                highest = height;
            }
        }
        return highest;
    }
}
