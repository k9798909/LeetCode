package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST530 {
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

	
	List<Integer> list = new ArrayList<>();

	public int getMinimumDifference(TreeNode root) {
		orderAdd(root);
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(list.get(i) - list.get(i - 1), min);
		}
		
		return min;
	}

	public void orderAdd(TreeNode root) {
		if (root == null) {
			return;
		}
		orderAdd(root.left);
		list.add(root.val);
		orderAdd(root.right);
	}
}
