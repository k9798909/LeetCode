package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths257 {

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

	List<String> list = new ArrayList<>();
	LinkedList<String> subList = new LinkedList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		subList.add(String.valueOf(root.val));
		vist(root);
		return list;
	}

	public void vist(TreeNode node) {
		if (node.left == null && node.right == null) {
			list.add(subList.stream().collect(Collectors.joining("->")));
			return;
		}

		if (node.left != null) {
			subList.add(String.valueOf(node.left.val));
			vist(node.left);
			subList.removeLast();
		}

		if (node.right != null) {
			subList.add(String.valueOf(node.right.val));
			vist(node.right);
			subList.removeLast();
		}
	}
}
