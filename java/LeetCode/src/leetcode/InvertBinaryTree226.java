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
		swap(root);
		return root;
	}

	public void swap(TreeNode node) {
		TreeNode temp = node.right;
		node.right = node.left;
		node.left = temp;

		if (node.right != null) {
			swap(node.right);
		}

		if (node.left != null) {
			swap(node.left);
		}
	}
}
