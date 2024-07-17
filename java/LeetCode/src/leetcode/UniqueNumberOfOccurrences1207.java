package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences1207 {
    /**
     * Given an array of integers arr,
     * return true if the number of occurrences of each value in the array is unique or false otherwise.
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            //map.put(arr[i], map.computeIfAbsent(arr[i], k -> 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : map.values()) {
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
        }
        return true;
    }
}
