package leetcode;

/**
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 * <p>
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 * <p>
 * Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
 */
public class MaximumMatrixSum1975 {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0, negativeCount = 0, minAbsVal = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                int absNum = Math.abs(num);
                sum += absNum;
                if (num < 0) {
                    negativeCount++;
                }
                minAbsVal = Math.min(absNum, minAbsVal);
            }
        }

        // 如果負數是奇數個，無論如何操作，最後一定會剩下一個負號。
        // 為了讓總和最大，我們將這個負號交給絕對值最小的數字 (minAbsVal)。
        // 公式：總和 - 2 * 最小值
        if (negativeCount % 2 != 0) {
            sum -= 2 * minAbsVal;
        }

        return sum;
    }
}
