package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        int maxLevel = 0, maxSum = Integer.MIN_VALUE, curLevel = 1;

        while (!level.isEmpty()) {
            int sum = 0;
            int levelSize = level.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = level.poll();
                sum += node.val;
                if (node.left != null) {
                    level.add(node.left);
                }

                if (node.right != null) {
                    level.add(node.right);
                }
            }

            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = curLevel;
            }

            curLevel++;
        }

        return maxLevel;
    }

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
}
