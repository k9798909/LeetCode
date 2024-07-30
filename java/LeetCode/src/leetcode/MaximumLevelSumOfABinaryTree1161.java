package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree1161 {
	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int maxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();

			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				sum += temp.val;
				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}

			level++;
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
