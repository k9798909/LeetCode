package leetcode;

public class InvertBinaryTree226 {
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

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		invert(root.left, root.right);
		return root;
	}

	public void invert(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return;
		}
		
		invert(left.left,right.right);
		invert(right.left,left.right);
		
		int tempVal = left.val;
		left.val = right.val;
		right.val = tempVal;
	}
}
