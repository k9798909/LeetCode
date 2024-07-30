package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
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

	// 前序遍歷（Preorder Traversal）：遍歷順序為「根-左-右」，即先訪問節點本身，然後遞歸遍歷左子樹和右子樹。
	//
	// 中序遍歷（Inorder Traversal）：遍歷順序為「左-根-右」，即先遞歸遍歷左子樹，然後訪問節點本身，最後遞歸遍歷右子樹。
	//
	// 後序遍歷（Postorder Traversal）：遍歷順序為「左-右-根」，即先遞歸遍歷左子樹，然後遞歸遍歷右子樹，最後訪問節點本身。
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}
		
		System.out.println(root.val);

		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || (!stack.isEmpty())) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			ans.add(curr.val);
			curr = curr.right;
		}

		return ans;
	}

	List<Integer> ans = new ArrayList<>();

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		ans.add(root.val);
		inorder(root.right);
	}

}
