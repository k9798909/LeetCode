package leetcode;

public class RecoverBinarySearchTree99 {
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
	
	TreeNode pre = null;
	TreeNode first = null;
	TreeNode second = null;
	
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		//前一個節點大於上一個節點
		if (pre != null && pre.val > root.val ) {
			if (first == null) {
				first = pre;
			}
			second = root;
		}
		pre = root;
		inorder(root.right);
	}

}
