package leetcode;

import java.util.Arrays;

public class IncreasingTripletSubsequence334 {
    /**
     * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
     * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
     * indices exists, return false.
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE; // 初始化第一個最小值為整數的最大值
        int b = Integer.MAX_VALUE; // 初始化第二個最小值為整數的最大值

        // 遍歷數組中的每個元素
        for (int num : nums) {
            if (num <= a) { // 如果當前數字小於或等於第一個最小值
                a = num; // 更新第一個最小值為當前數字
            } else if (num <= b) { // 如果當前數字大於第一個最小值但小於或等於第二個最小值
                b = num; // 更新第二個最小值為當前數字
            } else { // 如果當前數字大於第一個和第二個最小值，找到了遞增三元組
                return true; // 返回true
            }
        }

        return false; // 遍歷完數組沒有找到遞增三元組，返回false
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence334().increasingTriplet(new int[] {20,100,10,12,5,13}));
    }
}
