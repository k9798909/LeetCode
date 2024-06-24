package leetcode;

public class ProductOfArrayExceptSelf238 {

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        // 計算前綴積
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp = temp * nums[i];
        }

        // 計算後綴積並相乘
        temp = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp *= nums[i];
        }

        return result;
    }

}
