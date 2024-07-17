package leetcode;

import java.util.*;

public class FindTheDifferenceOfTwoArrays2215 {
    /**
     * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
     * <p>
     * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
     * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
     * Note that the integers in the lists may be returned in any order.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if (set1.contains(nums2[i])) {
                set3.add(nums2[i]);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (Integer num : set1) {
            if (!set3.contains(num)) {
                list1.add(num);
            }
        }

        for (Integer num : set2) {
            if (!set3.contains(num)) {
                list2.add(num);
            }
        }

        return Arrays.asList(list1, list2);
    }
}
