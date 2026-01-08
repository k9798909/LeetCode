package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 * <p>
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 */
public class MaximumProductOfSplittedBinaryTree1339 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    long max = 0;
    long total = 0;

    public int maxProduct(TreeNode root) {
        total = total(root);
        dfs(root);
        return (int) (max % 1000000007L);
    }

    public long total(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + total(root.left) + total(root.right);
    }

    public long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long sum = root.val + dfs(root.left) + dfs(root.right);
        max = Math.max(max, sum * (total - sum));
        return sum;
    }
}
