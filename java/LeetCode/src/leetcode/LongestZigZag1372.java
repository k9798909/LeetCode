package leetcode;

/**
 * You are given the root of a binary tree.
 * 
 * A ZigZag path for a binary tree is defined as follow:
 * 
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current
 * node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node
 * has a length of 0).
 * 
 * Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZag1372 {
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

	int maxCnt = 0;

	public int longestZigZag(TreeNode root) {
		maxZigZag(root.left, true, 0);
		maxZigZag(root.right, false, 0);
		return maxCnt;
	}

	public void maxZigZag(TreeNode node, boolean isLeft, int cnt) {
		if (node == null) {
			if (cnt > maxCnt) {
				maxCnt = cnt;
			}
			return;
		}

		if (isLeft) {
			maxZigZag(node.left, true, 0);
			maxZigZag(node.right, false, cnt + 1);
		} else {
			maxZigZag(node.right, false, 0);
			maxZigZag(node.left, true, cnt + 1);
		}

	}

}
