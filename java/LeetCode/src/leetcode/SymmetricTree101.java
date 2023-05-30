package leetcode;

public class SymmetricTree101 {
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

	public boolean isSymmetric(TreeNode root) {
		return dps(root.left,root.right);
	}

	public boolean dps(TreeNode left, TreeNode right) {
		if (left != null && right != null && right.val == left.val) {
			return dps(left.left, right.right) && dps(right.left, left.right);
		} else if (left == null && right == null) {
			return true;
		} else {
			return false;
		}
	}
}
