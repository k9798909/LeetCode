package leetcode;

import java.util.*;

/**
 * You are given the root of a binary tree and a positive integer k.
 * <p>
 * The level sum in the tree is the sum of the values of the nodes that are on the same level.
 * <p>
 * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
 * <p>
 * Note that two nodes are on the same level if they have the same distance from the root.
 */
public class KthLargestSumInABinaryTree2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);

        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = levelQueue.poll();
                sum += node.val;
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
            }
            sums.add(sum);
        }

        if (sums.size() < k) {
            return -1;
        }

        Collections.sort(sums);
        return sums.get(sums.size() - k);
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


