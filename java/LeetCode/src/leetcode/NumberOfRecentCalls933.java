package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls933 {

    /**
     * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
     * <p>
     * Implement the RecentCounter class:
     * <p>
     * RecentCounter() Initializes the counter with zero recent requests.
     * <p>
     * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
     * <p>
     * and returns the number of requests that has happened in the past 3000 milliseconds
     * <p>
     * (including the new request). Specifically,
     * <p>
     * return the number of requests that have happened in the inclusive range [t - 3000, t].
     * <p>
     * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
     */
    class RecentCounter {
        private Queue<Integer> queue = new LinkedList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            int min = t - 3000;

            while (!queue.isEmpty() && queue.peek() < min) {
                queue.poll();
            }

            queue.add(t);
            return queue.size();
        }
    }

}
