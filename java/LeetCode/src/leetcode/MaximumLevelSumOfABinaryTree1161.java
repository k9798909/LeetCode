package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree1161 {
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int maxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int level = 0;
		while (!queue.isEmpty()) {
			level += 1;
			int curSum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				curSum += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (curSum > maxSum) {
				maxSum = curSum;
				maxLevel = level;
			}
		}
		return maxLevel;
	}

	public class TreeNode {
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
